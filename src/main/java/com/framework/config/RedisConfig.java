package com.framework.config;

import java.time.Duration;

import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;


@Configuration
@EnableRedisRepositories
public class RedisConfig {
	
	@Bean
	public JedisConnectionFactory connectionFactory() {
		RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration();
		configuration.setHostName("redis-test-2.qilbkj.ng.0001.apse1.cache.amazonaws.com");
		configuration.setPort(6379);
		
		return new JedisConnectionFactory(configuration);
	}
	
	@Bean
	@Primary
    public CacheManager redisCacheManager() {
         RedisSerializationContext.SerializationPair<Object> jsonSerializer = 
         RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
         return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(connectionFactory())
                .cacheDefaults(
                    RedisCacheConfiguration.defaultCacheConfig()
                            .entryTtl(Duration.ofDays(1))
                            .serializeValuesWith(jsonSerializer)
                )
                .build();
    }
	

}
