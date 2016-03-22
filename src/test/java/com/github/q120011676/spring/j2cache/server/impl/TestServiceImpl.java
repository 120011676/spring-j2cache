package com.github.q120011676.spring.j2cache.server.impl;

import com.github.q120011676.spring.j2cache.server.TestService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by say on 3/21/16.
 */
@Service("ts")
@CacheConfig(cacheNames = {"spring_j2"}, keyGenerator = "smallHump")
public class TestServiceImpl implements TestService {
    @Override
    @Cacheable
    public String getName() {
        return "A";
    }

    @Override
    @CachePut
    public String setName(String name) {
        return name;
    }

    @Override
    @CacheEvict
    public void cleanName() {
    }
}
