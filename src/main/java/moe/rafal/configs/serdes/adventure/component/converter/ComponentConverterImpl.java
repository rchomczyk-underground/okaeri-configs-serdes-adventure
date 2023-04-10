package moe.rafal.configs.serdes.adventure.component.converter;

import net.kyori.adventure.text.Component;

import java.util.function.Function;

public class ComponentConverterImpl implements ComponentConverter {

    private final Function<Component, String> mutationFunction;
    private final Function<String, Component> reversedFunction;

    protected ComponentConverterImpl(Function<Component, String> mutationFunction, Function<String, Component> reversedFunction) {
        this.mutationFunction = mutationFunction;
        this.reversedFunction = reversedFunction;
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
