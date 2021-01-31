package dk.workkit.memcache;

import dk.workkit.domain.Model;
import org.javatuples.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class InMemoryCache implements MemCache<Model> {
    private final int MAX_SIZE;
    private Map<String, Pair<Long, Model>> cache;
    private ReentrantLock lock;

    public InMemoryCache(int maxSize) {
        this.cache = new HashMap<>();
        this.lock = new ReentrantLock(true);
        this.MAX_SIZE = maxSize;
    }

    @Override
    public boolean put(String id, Model obj) {
        lock.lock();
        if (cache.size() >= MAX_SIZE) {
            removeLeastPopularEntry();
        }
        Pair<Long, Model> existing = cache.get(id);
        long popularity = 0;
        if (existing != null) {
            popularity = existing.getValue0();
        }
        cache.put(id, new Pair<>(popularity, obj));
        lock.unlock();
        return true;
    }

    private void removeLeastPopularEntry() {
        cache.values().stream()
                .min(Comparator.comparingLong(Pair::getValue0))
                .stream()
                .findFirst()
                .ifPresent(objects -> cache.remove(objects.getValue1().getId()));
    }

    @Override
    public Model get(String id) {
        lock.lock();
        Pair<Long, Model> entry = cache.get(id);
        if (entry == null) {
            throw new CacheMissException();
        }
        entry = entry.setAt0(entry.getValue0() + 1);
        update(id, entry);
        lock.unlock();
        return entry.getValue1();
    }

    private void update(String id, Pair<Long, Model> pair) {
        cache.put(id, pair);
    }

    @Override
    public boolean clear() {
        cache.clear();
        return true;
    }

    @Override
    public void remove(String id) {
        lock.lock();
        cache.remove(id);
        lock.unlock();
    }

    Map<String, Pair<Long, Model>> getCache() {
        return cache;
    }

    void setCache(Map<String, Pair<Long, Model>> cache) {
        this.cache = cache;
    }

}
