package moe.rafal.configs.serdes.adventure.component.converter.impl;

import moe.rafal.configs.serdes.adventure.component.converter.ComponentConverter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FlexibleComponentConverterTests {

    private final ComponentConverter componentConverter = new FlexibleComponentConverter(
        MiniMessage.builder()
            .postProcessor(new LegacyColorProcessor())
            .build());

    @Test
    void serializeMessageWithoutContent() {
        assertEquals("", componentConverter.mutate(Component.empty()));
    }

    @ParameterizedTest
    @MethodSource("getMessageSubjectsWithVarietyOfFormats")
    void serializationAndDeserializationShouldSucceedWithoutMalformation(String value) {
        assertEquals(value, componentConverter.mutate(componentConverter.reverse(value)));
    }

    @Test
    void serializationShouldConvertToMiniMessageIfNotIndexed() {
        assertEquals("<red>Hello", componentConverter.mutate(Component.text("Hello").color(NamedTextColor.RED)));
    }

    private static List<String> getMessageSubjectsWithVarietyOfFormats() {
        return Arrays.asList(
            "<red>Hello <yellow>World<rainbow>!",
            "&cHello &eWorld&d!",
            "<red>Hello &eWorld<rainbow>!"
        );
    }
}
