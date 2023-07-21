package moe.rafal.configs.serdes.adventure.index;

public final class MapBasedIndexFactory {

    private MapBasedIndexFactory() {

    }

    public static <K, V> MapBasedIndex<K, V> newIndex() {
        return new MapBasedIndex<>();
    }
}
