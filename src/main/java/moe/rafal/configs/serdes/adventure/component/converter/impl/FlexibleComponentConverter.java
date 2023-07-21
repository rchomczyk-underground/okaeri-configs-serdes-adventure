package moe.rafal.configs.serdes.adventure.component.converter.impl;

import moe.rafal.configs.serdes.adventure.index.Index;
import moe.rafal.configs.serdes.adventure.index.MapBasedIndexFactory;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

import java.util.Optional;

public class FlexibleComponentConverter extends MiniMessageComponentConverter {

    private final Index<String, Component> conversionIndex;

    public FlexibleComponentConverter(MiniMessage miniMessage) {
        super(miniMessage);
        this.conversionIndex = MapBasedIndexFactory.newIndex();
    }

    @Override
    public String mutate(Component parsedComponent) {
        final String input = conversionIndex.getByValue(parsedComponent);
        conversionIndex.remove(input, parsedComponent);
        return Optional.ofNullable(input)
            .orElseGet(() -> super.mutate(parsedComponent));
    }

    @Override
    public Component reverse(String input) {
        final Component parsedComponent = super.reverse(input);
        conversionIndex.put(input, parsedComponent);
        return Optional.ofNullable(parsedComponent)
            .orElseGet(() -> super.reverse(input));
    }
}