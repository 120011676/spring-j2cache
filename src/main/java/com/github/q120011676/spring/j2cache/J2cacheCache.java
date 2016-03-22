package com.github.q120011676.spring.j2cache;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import net.oschina.j2cache.J2Cache;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

/**
 * Created by say on 3/21/16.
 */
public class J2cacheCache implements Cache {
    private CacheChannel cacheChannel = J2Cache.getChannel();
    private String name;

    public J2cacheCache() {
        this.setName("SPRING_J2CACHE");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this.cacheChannel;
    }

    @Override
    public ValueWrapper get(Object o) {
        CacheObject co = this.cacheChannel.get(this.getName(), o);
        return co.getValue()!= null ? new SimpleValueWrapper(co.getValue()) : null;
    }

    @Override
    public <T> T get(Object o, Class<T> aClass) {
        CacheObject co = this.cacheChannel.get(this.getName(), o);
        return co.getValue() != null ? (T) co.getValue() : null;
    }

    @Override
    public void put(Object o, Object o1) {
        this.cacheChannel.set(this.getName(), o, o1);
    }

    @Override
    public ValueWrapper putIfAbsent(Object o, Object o1) {
        CacheObject co = this.cacheChannel.get(this.getName(), o);
        if (co.getValue() != null) {
            this.put(o, o1);
            return null;
        }
        return new SimpleValueWrapper(co.getValue());
    }

    @Override
    public void evict(Object o) {
        this.cacheChannel.evict(this.getName(), o);
    }

    @Override
    public void clear() {
        this.cacheChannel.clear(this.getName());
    }
}
