package com.quest.test.cache.guava_cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Quest on 2018/5/15.
 */
public abstract class BaseProvide<T> {
    protected LoadingCache<String, T> store;

    public BaseProvide() {
        createCacheStore();
    }
    protected void createCacheStore(){
        store = CacheBuilder.newBuilder().expireAfterAccess(6, TimeUnit.MINUTES).maximumSize(1000).build(new CacheLoader<String, T>() {
            @Override
            public T load(String key) throws Exception {
                return loadData(key);
            }
        });
    }

    abstract T loadData(String key);

    public boolean isLoaded(String key){
        return this.store.asMap().containsKey(key);
    }

    public void remove(String key){
        this.store.invalidate(key);
    }

    public void removeAll(){
        Set<String> keys = this.store.asMap().keySet();
        for (String key : keys) {
            store.invalidate(key);
        }
    }

    public T get(String key) {
        try {
            return this.store.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void add(String key, T data) {
        this.store.put(key, data);
    }

}
