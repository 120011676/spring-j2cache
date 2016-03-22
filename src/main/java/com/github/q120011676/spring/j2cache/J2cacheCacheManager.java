package com.github.q120011676.spring.j2cache;

import org.springframework.cache.Cache;
import org.springframework.cache.transaction.AbstractTransactionSupportingCacheManager;

import java.util.Collection;

/**
 * Created by say on 3/21/16.
 */
public class J2cacheCacheManager extends AbstractTransactionSupportingCacheManager {
    private Collection<? extends J2cacheCache> caches;

    public void setCaches(Collection<? extends J2cacheCache> caches) {
        this.caches = caches;
    }

    @Override
    protected Collection<? extends Cache> loadCaches() {
        return this.caches;
    }
}
