package moe.rafal.configs.serdes.adventure.index;

final class IndexAssertions {

    private IndexAssertions() {

    }

    static void assertNotNull(Object value) {
        if (value == null) {
            throw new IllegalArgumentException("Value cannot be null");
        }
    }
}
