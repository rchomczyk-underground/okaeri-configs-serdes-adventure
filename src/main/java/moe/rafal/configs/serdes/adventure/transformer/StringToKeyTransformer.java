package moe.rafal.configs.serdes.adventure.transformer;

import eu.okaeri.configs.schema.GenericsPair;
import eu.okaeri.configs.serdes.BidirectionalTransformer;
import eu.okaeri.configs.serdes.SerdesContext;
import net.kyori.adventure.key.Key;
import org.jetbrains.annotations.NotNull;

public class StringToKeyTransformer extends BidirectionalTransformer<String, Key> {

    @Override
    public GenericsPair<String, Key> getPair() {
        return genericsPair(String.class, Key.class);
    }

    @Override
    public Key leftToRight(@NotNull String data, @NotNull SerdesContext serdesContext) {
        return Key.key(data);
    }

    @Override
    public String rightToLeft(@NotNull Key data, @NotNull SerdesContext serdesContext) {
        return data.asString();
    }
}
