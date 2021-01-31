package dk.workkit.memcache;

public interface MemCache<T> {
    boolean put(String id, T obj);
    T get(String id);
    boolean clear();
    void remove(String id);
}
