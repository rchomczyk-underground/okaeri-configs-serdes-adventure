package moe.rafal.configs.serdes.transformer;

import eu.okaeri.configs.schema.GenericsPair;
import eu.okaeri.configs.serdes.BidirectionalTransformer;
import eu.okaeri.configs.serdes.SerdesContext;
import moe.rafal.configs.serdes.component.converter.ComponentConverter;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public class StringToComponentTransformer extends BidirectionalTransformer<String, Component> {

    private final ComponentConverter componentConverter;

    public StringToComponentTransformer(ComponentConverter componentConverter) {
        this.componentConverter = componentConverter;
    }

    @Override
    public GenericsPair<String, Component> getPair() {
        return genericsPair(String.class, Component.class);
    }

    @Override
    public Component leftToRight(@NotNull String data, @NotNull SerdesContext serdesContext) {
        return componentConverter.reverse(data);
    }

    @Override
    public String rightToLeft(@NotNull Component data, @NotNull SerdesContext serdesContext) {
        return componentConverter.mutate(data);
    }
}
