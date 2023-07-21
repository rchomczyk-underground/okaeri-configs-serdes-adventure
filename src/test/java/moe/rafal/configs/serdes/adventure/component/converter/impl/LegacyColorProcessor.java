package moe.rafal.configs.serdes.adventure.component.converter.impl;

import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

class LegacyColorProcessor implements UnaryOperator<Component> {

    private static final LegacyComponentSerializer SERIALIZER = LegacyComponentSerializer.legacyAmpersand()
        .toBuilder()
        .hexColors()
        .character('&')
        .hexCharacter('#')
        .useUnusualXRepeatedCharacterHexFormat()
        .build();

    LegacyColorProcessor() {

    }

    private Component component(String text) {
        return SERIALIZER.deserialize(text);
    }

    @Override
    public Component apply(Component component) {
        return component.replaceText(builder -> builder.match(Pattern.compile(".*"))
            .replacement((matchResult, builder1) -> this.component(matchResult.group())));
    }
}
