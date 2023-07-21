package moe.rafal.configs.serdes.adventure.index;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MapBasedIndexTests {

    private static final String SAMPLE_TEXT = "AaA";

    private static final String SAMPLE_TEXT_SECOND = "bBb";

    private final Index<String, String> underlyingIndex = MapBasedIndexFactory.newIndex();

    @AfterEach
    void flushIndex() {
        underlyingIndex.clear();
    }

    @Test
    void putShouldSucceedWithUniqueValues() {
        underlyingIndex.put(SAMPLE_TEXT, SAMPLE_TEXT_SECOND);
        assertEquals(SAMPLE_TEXT, underlyingIndex.getByValue(SAMPLE_TEXT_SECOND));
        assertEquals(SAMPLE_TEXT_SECOND, underlyingIndex.getByKey(SAMPLE_TEXT));
    }

    @Test
    void putShouldSucceedWithNonUniqueValues() {
        underlyingIndex.put(SAMPLE_TEXT, SAMPLE_TEXT);
        assertEquals(SAMPLE_TEXT, underlyingIndex.getByKey(SAMPLE_TEXT));
        assertEquals(SAMPLE_TEXT, underlyingIndex.getByValue(SAMPLE_TEXT));
    }

    @Test
    void putShouldThrowWhenKeyIsNull() {
        assertThrows(IllegalArgumentException.class, () -> underlyingIndex.put(null, SAMPLE_TEXT_SECOND));
    }

    @Test
    void putShouldThrowWhenValueIsNull() {
        assertThrows(IllegalArgumentException.class, () -> underlyingIndex.put(SAMPLE_TEXT, null));
    }

    @Test
    void getByKeyShouldReturnValue() {
        underlyingIndex.put(SAMPLE_TEXT, SAMPLE_TEXT_SECOND);
        assertEquals(SAMPLE_TEXT_SECOND, underlyingIndex.getByKey(SAMPLE_TEXT));
    }

    @Test
    void getByKeyShouldReturnNullIfNotExists() {
        assertNull(underlyingIndex.getByKey(SAMPLE_TEXT));
    }

    @Test
    void getByValueShouldReturnKey() {
        underlyingIndex.put(SAMPLE_TEXT, SAMPLE_TEXT_SECOND);
        assertEquals(SAMPLE_TEXT, underlyingIndex.getByValue(SAMPLE_TEXT_SECOND));
    }

    @Test
    void getByValueShouldReturnNullIfNotExists() {
        assertNull(underlyingIndex.getByValue(SAMPLE_TEXT_SECOND));
    }

    @Test
    void removeShouldRemoveKeyAndValue() {
        putSubjectsAndValidateIndex();

        underlyingIndex.remove(SAMPLE_TEXT, SAMPLE_TEXT_SECOND);
        assertNull(underlyingIndex.getByKey(SAMPLE_TEXT));
        assertNull(underlyingIndex.getByValue(SAMPLE_TEXT_SECOND));
    }

    @Test
    void clearShouldRemoveAllKeysAndValues() {
        putSubjectsAndValidateIndex();

        underlyingIndex.clear();
        assertNull(underlyingIndex.getByKey(SAMPLE_TEXT));
        assertNull(underlyingIndex.getByValue(SAMPLE_TEXT_SECOND));
    }
    
    private void putSubjectsAndValidateIndex() {
        underlyingIndex.put(SAMPLE_TEXT, SAMPLE_TEXT_SECOND);
        assertEquals(SAMPLE_TEXT_SECOND, underlyingIndex.getByKey(SAMPLE_TEXT));
        assertEquals(SAMPLE_TEXT, underlyingIndex.getByValue(SAMPLE_TEXT_SECOND));
    }
}
