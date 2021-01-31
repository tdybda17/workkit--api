package dk.workkit.endpoints.beans;

import dk.workkit.database.databases.UserDatabase;
import dk.workkit.memcache.InMemoryCache;
import dk.workkit.repoadapter.adapters.UserDbAdapter;
import dk.workkit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Repositories {

    @Autowired
    private InMemoryCache inMemoryCache;

    @Bean
    public UserRepository userRepository() {
        return new UserDbAdapter(new UserDatabase(), inMemoryCache);
    }

}
