package moe.rafal.configs.serdes.serializer;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.title.Title;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Duration;

public class TitleSerializer implements ObjectSerializer<Title> {

    @Override
    public boolean supports(@NotNull Class<? super Title> type) {
        return Title.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(@NotNull Title object, @NotNull SerializationData data, @NotNull GenericsDeclaration generics) {
        data.add("title", object.title(), Component.class);
        data.add("subtitle", object.subtitle(), Component.class);
        data.add("times", object.times());
    }

    @Override
    public Title deserialize(@NotNull DeserializationData data, @NotNull GenericsDeclaration generics) {
        return Title.title(
            data.get("title", Component.class),
            data.get("subtitle", Component.class),
            data.get("times", Title.Times.class));
    }

    public static class TimesSerializer implements ObjectSerializer<Title.Times> {

        @Override
        public boolean supports(@NotNull Class<? super Title.Times> type) {
            return Title.Times.class.isAssignableFrom(type);
        }

        @Override
        public void serialize(@NotNull Title.Times object, @NotNull SerializationData data, @NotNull GenericsDeclaration generics) {
            data.add("stay-in", object.stay());
            data.add("fade-in", object.fadeIn());
            data.add("fade-out", object.fadeOut());
        }

        @Override
        public Title.Times deserialize(@NotNull DeserializationData data, @NotNull GenericsDeclaration generics) {
            return getTimes(
                data.get("stay-in", Duration.class),
                data.get("fade-in", Duration.class),
                data.get("fade-out", Duration.class));
        }

        @Deprecated
        private Title.Times getTimes(@NotNull Duration stayIn, @NotNull Duration fadeIn, @NotNull Duration fadeOut) {
            try {
                Method method = Title.Times.class.getMethod("times", Duration.class, Duration.class, Duration.class);
                method.setAccessible(true);
                return (Title.Times) method.invoke(null, fadeIn, stayIn, fadeOut);
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException exception) {
                // noinspection all
                return Title.Times.of(fadeIn, stayIn, fadeOut);
            }
        }
    }
}
