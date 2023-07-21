package moe.rafal.configs.serdes.adventure.index;

public interface Index<K, V> {

    void put(K key, V value);

    V getByKey(K key);

    K getByValue(V value);

    void remove(K key, V value);

    void clear();
}
