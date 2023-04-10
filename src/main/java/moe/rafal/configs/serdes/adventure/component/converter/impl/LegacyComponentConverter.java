package moe.rafal.configs.serdes.adventure.component.converter.impl;

import moe.rafal.configs.serdes.adventure.component.converter.ComponentConverterImpl;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public class LegacyComponentConverter extends ComponentConverterImpl {

    public LegacyComponentConverter(LegacyComponentSerializer componentSerializer) {
        super(
            componentSerializer::serialize,
            componentSerializer::deserialize);
    }

    public LegacyComponentConverter() {
        this(LegacyComponentSerializer.legacyAmpersand());
    }
}
