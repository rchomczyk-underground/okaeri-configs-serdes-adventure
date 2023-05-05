package moe.rafal.configs.serdes.adventure.transformer;

import eu.okaeri.configs.configurer.InMemoryConfigurer;
import eu.okaeri.configs.serdes.SerdesContext;
import net.kyori.adventure.text.format.NamedTextColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringToNamedColorTransformerTests {

    private final StringToNamedColorTransformer transformer = new StringToNamedColorTransformer();
    private final SerdesContext inMemorySerdesContext = SerdesContext.of(new InMemoryConfigurer());

    @Test
    void mapNamedTextColorIntoString() {
        assertEquals("red", transformer.rightToLeft(NamedTextColor.RED, inMemorySerdesContext));
    }

    @Test
    void mapStringIntoNamedTextColor() {
        assertEquals(NamedTextColor.RED, transformer.leftToRight("red", inMemorySerdesContext));
    }

    @Test
    void mapStringIntoNamedTextColorWithMixedCase() {
        assertEquals(NamedTextColor.RED, transformer.leftToRight("ReD", inMemorySerdesContext));
    }
}
