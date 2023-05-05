package moe.rafal.configs.serdes.adventure.transformer;

import eu.okaeri.configs.schema.GenericsPair;
import eu.okaeri.configs.serdes.BidirectionalTransformer;
import eu.okaeri.configs.serdes.SerdesContext;
import net.kyori.adventure.text.format.NamedTextColor;
import org.jetbrains.annotations.NotNull;

import java.util.Locale;

public class StringToNamedColorTransformer extends BidirectionalTransformer<String, NamedTextColor> {
    
    @Override
    public GenericsPair<String, NamedTextColor> getPair() {
        return genericsPair(String.class, NamedTextColor.class);
    }

    @Override
    public NamedTextColor leftToRight(@NotNull String data, @NotNull SerdesContext serdesContext) {
        return NamedTextColor.NAMES.value(data.toLowerCase(Locale.ROOT));
    }

    @Override
    public String rightToLeft(@NotNull NamedTextColor data, @NotNull SerdesContext serdesContext) {
        return NamedTextColor.NAMES.key(data);
    }
}
