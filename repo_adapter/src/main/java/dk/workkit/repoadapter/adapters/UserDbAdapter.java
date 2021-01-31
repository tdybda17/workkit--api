package dk.workkit.repoadapter.adapters;

import dk.workkit.domain.Model;
import dk.workkit.domain.User;
import dk.workkit.memcache.CacheMissException;
import dk.workkit.memcache.MemCache;
import dk.workkit.repositories.UserRepository;
import dk.workkit.tools.FilterBuilder;

import java.util.List;


public class UserDbAdapter implements UserRepository {

    private final UserRepository mainDb;
    private final MemCache<Model> cache;

    public UserDbAdapter(
            UserRepository mainDb,
            MemCache<Model> cache) {
        this.mainDb = mainDb;
        this.cache = cache;
    }

    @Override
    public User save(User user) {
        User savedUser = mainDb.save(user);
        cache.put(savedUser.getId(), savedUser);
        return savedUser;
    }

    @Override
    public void delete(User user) {
        delete(user.getId());
    }

    @Override
    public void delete(String id) {
        mainDb.delete(id);
        cache.remove(id);
    }

    @Override
    public User get(String id) {
        try {
            return (User) cache.get(id);
        } catch (CacheMissException e) {
            return mainDb.get(id);
        }
    }

    @Override
    public List<User> filter(FilterBuilder filter, int from, int to) {
        return null;
    }
}
