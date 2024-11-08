package fr.ctb.labs.cache.config;

import fr.ctb.labs.cache.CacheFeatureApplication;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Slf4j
@EnableCaching
@EnableScheduling
@EntityScan("fr.ctb.labs.cache.*")
@Configuration
@ComponentScan(basePackageClasses = CacheFeatureApplication.class)
public class SpringConfig {

    public static final String CHARACTERS = "characters";
    public static final String BOOKS = "books";

    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager(CHARACTERS, BOOKS);
    }

    @Caching(evict = {
        @CacheEvict(value = CHARACTERS, allEntries = true),
        @CacheEvict(value = BOOKS, allEntries = true)
    })
    @Scheduled(fixedRateString = "${spring.caching.ttl}")
    public void emptyAllCache() {
        log.info("Emptying all caches is done");
    }

}
