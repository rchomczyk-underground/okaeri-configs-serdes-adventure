package moe.rafal.configs.serdes.adventure.index;

import java.util.HashMap;
import java.util.Map;

import static moe.rafal.configs.serdes.adventure.index.IndexAssertions.assertNotNull;

class MapBasedIndex<K, V> implements Index<K, V> {

    private final Map<V, K> keyByValue;
    private final Map<K, V> valueByKey;

    MapBasedIndex() {
        this.keyByValue = new HashMap<>();
        this.valueByKey = new HashMap<>();
    }
    
    @Override
    public void put(K key, V value) {
        assertNotNull(key);
        assertNotNull(value);

        keyByValue.put(value, key);
        valueByKey.put(key, value);
    }

    @Override
    public V getByKey(K key) {
        return valueByKey.get(key);
    }

    @Override
    public K getByValue(V value) {
        return keyByValue.get(value);
    }

    @Override
    public void remove(K key, V value) {
        keyByValue.remove(value);
        valueByKey.remove(key);
    }

    @Override
    public void clear() {
        keyByValue.clear();
        valueByKey.clear();
    }
}
