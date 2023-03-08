package moe.rafal.configs.serdes.component.converter;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

import java.util.function.Function;

public class ComponentConverterLegacy implements ComponentConverter {

    private final Function<Component, String> mutationFunction;
    private final Function<String, Component> reversedFunction;

    public ComponentConverterLegacy(LegacyComponentSerializer componentSerializer) {
        this.mutationFunction = componentSerializer::serialize;
        this.reversedFunction = componentSerializer::deserialize;
    }

    public ComponentConverterLegacy() {
        this(LegacyComponentSerializer.legacyAmpersand());
    }

    @Override
    public String mutate(Component value) {
        return mutationFunction.apply(value);
    }

    @Override
    public Component reverse(String value) {
        return reversedFunction.apply(value);
    }
}
