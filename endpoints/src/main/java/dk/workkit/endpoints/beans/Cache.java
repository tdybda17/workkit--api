package dk.workkit.endpoints.beans;

import dk.workkit.memcache.InMemoryCache;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Cache {

    @Bean
    public InMemoryCache inMemoryCache() {
        return new InMemoryCache(200);
    }

}
