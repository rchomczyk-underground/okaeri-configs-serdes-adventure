package moe.rafal.configs.serdes.component.converter.minimessage;

import moe.rafal.configs.serdes.component.converter.ComponentConverter;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.function.Function;

public class ComponentConverterMiniMessage implements ComponentConverter {

    private final Function<Component, String> mutationFunction;
    private final Function<String, Component> reversedFunction;

    public ComponentConverterMiniMessage(MiniMessage miniMessage) {
        this.mutationFunction = miniMessage::serialize;
        this.reversedFunction = miniMessage::deserialize;
    }

    public ComponentConverterMiniMessage() {
        this(MiniMessage.miniMessage());
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
