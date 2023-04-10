package moe.rafal.configs.serdes.adventure.serializer;

import eu.okaeri.configs.schema.GenericsDeclaration;
import eu.okaeri.configs.serdes.DeserializationData;
import eu.okaeri.configs.serdes.ObjectSerializer;
import eu.okaeri.configs.serdes.SerializationData;
import net.kyori.adventure.inventory.Book;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public class BookSerializer implements ObjectSerializer<Book> {

    @Override
    public boolean supports(@NotNull Class<? super Book> type) {
        return Book.class.isAssignableFrom(type);
    }

    @Override
    public void serialize(@NotNull Book object, @NotNull SerializationData data, @NotNull GenericsDeclaration generics) {
        data.add("title", object.title(), Component.class);
        data.add("author", object.author(), Component.class);
        data.addCollection("pages", object.pages(), Component.class);
    }

    @Override
    public Book deserialize(@NotNull DeserializationData data, @NotNull GenericsDeclaration generics) {
        return Book.book(
            data.get("title", Component.class),
            data.get("author", Component.class),
            data.getAsList("pages", Component.class));
    }
}
