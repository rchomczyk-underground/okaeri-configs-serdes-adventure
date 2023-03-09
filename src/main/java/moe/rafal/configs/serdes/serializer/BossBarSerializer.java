package moe.rafal.configs.serdes.serializer;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

import java.util.HashSet;

public class BossBarSerializer implements ObjectSerializer<BossBar> {

    @Override
    public boolean supports(@NotNull Class<? super BossBar> type) {
        return BossBar.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(@NotNull BossBar object, @NotNull SerializationData data, @NotNull GenericsDeclaration generics) {
        data.add("name", object.name(), Component.class);
        data.add("progress", object.progress(), float.class);
        data.add("color", object.color(), BossBar.Color.class);
        data.add("overlay", object.overlay(), BossBar.Overlay.class);
        data.addCollection("flags", object.flags(), BossBar.Flag.class);
    }

    @Override
    public BossBar deserialize(@NotNull DeserializationData data, @NotNull GenericsDeclaration generics) {
        return BossBar.bossBar(
                data.get("name", Component.class),
                data.get("progress", float.class),
                data.get("color", BossBar.Color.class),
                data.get("overlay", BossBar.Overlay.class),
                new HashSet<>(data.getAsList("flags", BossBar.Flag.class))
        );
    }
}
