package moe.rafal.configs.serdes.component.converter;

import net.kyori.adventure.text.Component;

public interface ComponentConverter {

    String mutate(Component value);

    Component reverse(String value);
}
