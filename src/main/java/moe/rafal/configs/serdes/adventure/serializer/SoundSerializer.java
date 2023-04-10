package moe.rafal.configs.serdes.adventure.serializer;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.sound.Sound.Source;
import org.jetbrains.annotations.NotNull;

public class SoundSerializer implements ObjectSerializer<Sound> {

    @Override
    public boolean supports(@NotNull Class<? super Sound> type) {
        return Sound.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(@NotNull Sound object, @NotNull SerializationData data, @NotNull GenericsDeclaration generics) {
        data.add("name", object.name(), Key.class);
        data.add("pitch", object.pitch());
        data.add("source", object.source());
        data.add("volume", object.volume());
    }

    @Override
    public Sound deserialize(@NotNull DeserializationData data, @NotNull GenericsDeclaration generics) {
        return Sound.sound(
            data.get("name", Key.class),
            data.get("source", Source.class),
            data.get("volume", float.class),
            data.get("pitch", float.class));
    }
}
