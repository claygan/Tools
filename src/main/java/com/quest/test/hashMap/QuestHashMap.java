package com.quest.test.hashMap;

/**
 * Created by Quest on 2018/2/11.
 */
public class QuestHashMap<K, V> implements QuestMap<K, V> {
    private Entry<K, V>[] table = null;//数据数组
    private int size = 0;//元素个数
    private int defaultLength = 16;//默认长度
    private double defaultloader = 0.75;//加载因子

    public QuestHashMap() {
    }

    public QuestHashMap(int defaultLength, double defaultloader) {
        this.defaultLength = defaultLength;
        this.defaultloader = defaultloader;
    }

    @Override
    public V put(K k, V v) {
        //判断数组table是否存在
        if (table == null) {
            table = new Entry[defaultLength];
        }
        //每次插入前，判断当前size是否需要扩容
        if (size > defaultLength * defaultloader) {
            resize();//扩容
        }
        //通过hash算法计算得到index，确定数据应该处在数组中什么位置
        int index = getIndex(k);
        //判断index位置是否已存在元素了
        Entry<K, V> node = table[index];
        if(node == null){
            //当前位置没有元素，插入新建节点
            table[index] = new Node(k, v, null);
            size++;
        }else{
            while(node != null){
                //判断元素的key是否与新元素相等
                if (node.getKey().equals(k) || node.getKey() == k) {
                    //key相同，修改元素
                   return node.setValue(v);
                }else{
                    if (node.getNext() != null) {
                        node = node.getNext();
                    }else{
                        break;
                    }
                }
            }
            table[index] = new Node(k, v, table[index]);//复位并插入当前数据到数组中
            size++;
        }
        return v;
    }
    /**
     *  扩容
     */
    private void resize(){
        if (size > defaultLength * defaultloader) {
            System.out.println("=========>start resize");
            //新建一个数组用于扩容
            Entry<K, V>[] newTable = new Entry[defaultLength << 1];
            //原数组中的数据重新散列到新数组中
            for (int i = 0, len=table.length; i < len; i++) {
                Entry<K, V> node = table[i];
                while(node != null){
                    int index = getIndex(node.getKey(), newTable.length);
                    Entry<K, V> next = node.getNext();
                    node.setNext(newTable[index]);
                    newTable[index] = node;
                    node = next;
                }
            }
            //将原table替换为新table
            table = newTable;
            defaultLength = newTable.length;
            newTable = null;
            System.out.println("==============>end resize");
        }
    }
    private int getIndex(K k) {
        return getIndex(k, defaultLength);
    }
    private int getIndex(K k, int length) {
        return k.hashCode() & (length - 1);
    }
    public void print(){
        System.out.println("==============begin================");
        for (int i = 0, len = table.length; i < len; i++) {
            System.out.print("["+i+"]");
            Entry<K, V> node = table[i];
            if (node != null) {
                System.out.print("(" + node.getKey() + "," + node.getValue() + ")");
                while (node.getNext() != null) {
                    System.out.print("+(" + node.getNext().getKey() + "," + node.getNext().getValue() + ")");
                    node = node.getNext();
                }
            }
            System.out.println();
        }
        System.out.println("==============end===========>size:"+size());
    }
    @Override
    public V get(K k) {
        int index = getIndex(k);
        Entry<K, V> node = table[index];
        while(node != null){
            if (node.getKey().equals(k) || node.getKey() == k) {
                return node.getValue();
            }else{
                node = node.getNext();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }
    /**
     *  数据链表
     */
    static class Node<K,V> implements Entry<K,V>{
        private K key;
        private V value;
        private Entry<K, V> next;

        public Node(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public Entry<K, V> getNext() {
            return this.next;
        }

        @Override
        public Entry<K, V> setNext(Entry<K, V> entry) {
            Entry<K, V> oldNext = this.next;
            this.next = entry;
            return oldNext;
        }
    }
}
