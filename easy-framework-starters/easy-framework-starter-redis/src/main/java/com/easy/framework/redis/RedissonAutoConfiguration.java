package com.easy.framework.redis;

import com.easy.framework.redis.lock.LockAspect;
import com.easy.framework.redis.lock.LockProperties;
import com.easy.framework.redis.lock.locker.Locker;
import com.easy.framework.redis.lock.locker.RedissonLocker;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Redisson配置
 */
@Configuration(proxyBeanMethods = false)
@Import(LockAspect.class)
@EnableConfigurationProperties({RedisProperties.class, LockProperties.class})
public class RedissonAutoConfiguration {

    @Bean
    public RedissonClient redissonClient(@Value("${spring.redis.host}") String host,
                                         @Value("${spring.redis.port}") String port,
                                         @Value("${spring.redis.password}") String password,
                                         @Value("${spring.redis.database:0}") int database
    ) {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://" + host + ":" + port).setPassword(password);
        config.useSingleServer().setConnectionMinimumIdleSize(1);
        config.useSingleServer().setDatabase(database);
        return Redisson.create(config);
    }

    /**
     * 注入分布式锁，业务框架有需要也可以自己实现
     */
    @Bean
    @ConditionalOnMissingBean(Locker.class)
    public Locker locker(LockProperties lockProperties, RedissonClient redissonClient) {
        return new RedissonLocker(lockProperties.getType(), redissonClient);
    }
}
