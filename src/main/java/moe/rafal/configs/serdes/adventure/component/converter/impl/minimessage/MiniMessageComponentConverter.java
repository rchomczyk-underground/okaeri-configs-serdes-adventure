package moe.rafal.configs.serdes.adventure.component.converter.impl.minimessage;

import moe.rafal.configs.serdes.adventure.component.converter.ComponentConverterImpl;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class MiniMessageComponentConverter extends ComponentConverterImpl {

    public MiniMessageComponentConverter(MiniMessage miniMessage) {
        super(
            miniMessage::serialize,
            miniMessage::deserialize);
    }

    public MiniMessageComponentConverter() {
        this(MiniMessage.miniMessage());
    }
}
