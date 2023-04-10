package moe.rafal.configs.serdes.adventure.component.converter.impl;

import moe.rafal.configs.serdes.adventure.component.converter.ComponentConverter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LegacyComponentConverterTests {

    private final ComponentConverter componentConverter = new LegacyComponentConverter();

    @Test
    void serializeMessageWithoutContent() {
        assertEquals("", componentConverter.mutate(Component.empty()));
    }

    @Test
    void serializeMessageWithOneColor() {
        assertEquals("&7Hello world", componentConverter.mutate(Component.text("Hello world").color(NamedTextColor.GRAY)));
    }

    @Test
    void serializeMessageWithManyColors() {
        assertEquals("&7Hello &aWorld",
            componentConverter.mutate(Component.empty()
                .append(Component.text("Hello ").color(NamedTextColor.GRAY))
                .append(Component.text("World").color(NamedTextColor.GREEN))));
    }

    @Test
    void serializeMessageWithUnsupportedFormatting() {
        assertEquals("<red>Hello</red>", componentConverter.mutate(Component.text("<red>Hello</red>")));
    }

    @Test
    void deserializeMessageWithoutContent() {
        assertEquals(Component.empty(), componentConverter.reverse(""));
    }

    @Test
    void deserializeMessageWithOneColor() {
        assertEquals(Component.text("Hello world").color(NamedTextColor.GRAY), componentConverter.reverse("&7Hello world"));
    }

    @Test
    void deserializeMessageWithManyColors() {
        assertEquals(
            Component.empty()
                .append(Component.text("Hello ").color(NamedTextColor.GRAY))
                .append(Component.text("World").color(NamedTextColor.GREEN)),
            componentConverter.reverse("&7Hello &aWorld"));
    }

    @Test
    void deserializeMessageWithUnsupportedFormatting() {
        assertEquals(Component.text("<red>Hello</red>"), componentConverter.reverse("<red>Hello</red>"));
    }
}
