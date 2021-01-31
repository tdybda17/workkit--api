package dk.workkit.repositories;

import dk.workkit.domain.User;
import dk.workkit.tools.FilterBuilder;

import java.util.List;

public interface UserRepository {
    User save(User user);
    void delete(User user);
    void delete(String id);
    User get(String id);
    List<User> filter(FilterBuilder filter, int from, int to);
}
