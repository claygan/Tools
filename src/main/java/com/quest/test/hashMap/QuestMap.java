package com.quest.test.hashMap;

/**
 * Created by Quest on 2018/2/11.
 */
public interface QuestMap<K, V> {
    /**
     *  从集合中获取值
     */
    V get(K k);
    /**
     *  向集合中插入值
     */
    V put(K k, V v);
    /**
     *  获取集合大小
     */
    int size();

    /**
     *  用于获取集合中键值对的对象
     */
    interface Entry<K, V>{
        K getKey();
        V getValue();
        V setValue(V value);
        Entry<K, V> getNext();
        Entry<K, V> setNext(Entry<K, V> entry);
    }
}
