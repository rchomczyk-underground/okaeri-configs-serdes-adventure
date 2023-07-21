package moe.rafal.configs.serdes.adventure.component.converter.impl.minimessage;

import moe.rafal.configs.serdes.adventure.component.converter.ComponentConverter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MiniMessageComponentConverterTests {

    private final ComponentConverter componentConverter = new MiniMessageComponentConverter();

    @Test
    void serializeMessageWithoutContent() {
        assertEquals("", componentConverter.mutate(Component.empty()));
    }

    @Test
    void serializeMessageWithOneColor() {
        assertEquals("<gray>Hello world", componentConverter.mutate(Component.text("Hello world").color(NamedTextColor.GRAY)));
    }

    @Test
    void serializeMessageWithManyColors() {
        assertEquals("<gray>Hello </gray><green>World",
            componentConverter.mutate(Component.empty()
                .append(Component.text("Hello ").color(NamedTextColor.GRAY))
                .append(Component.text("World").color(NamedTextColor.GREEN))));
    }

    @Test
    void serializeMessageWithUnsupportedFormatting() {
        assertEquals("&cHello", componentConverter.mutate(Component.text("&cHello")));
    }

    @Test
    void deserializeMessageWithoutContent() {
        assertEquals(Component.empty(), componentConverter.reverse(""));
    }

    @Test
    void deserializeMessageWithOneColor() {
        assertEquals(Component.text("Hello world").color(NamedTextColor.GRAY), componentConverter.reverse("<gray>Hello world</gray>"));
    }

    @Test
    void deserializeMessageWithManyColors() {
        assertEquals(
            Component.empty()
                .append(Component.text("Hello ").color(NamedTextColor.GRAY))
                .append(Component.text("World").color(NamedTextColor.GREEN)),
            componentConverter.reverse("<gray>Hello </gray><green>World</green>"));
    }

    @Test
    void deserializeMessageWithUnsupportedFormatting() {
        assertEquals(Component.text("&cHello"), componentConverter.reverse("&cHello"));
    }
}
