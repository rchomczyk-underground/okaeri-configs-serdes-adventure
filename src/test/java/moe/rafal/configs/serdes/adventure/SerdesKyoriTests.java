package moe.rafal.configs.serdes.adventure;

import moe.rafal.configs.serdes.adventure.component.converter.impl.LegacyComponentConverter;
import moe.rafal.configs.serdes.adventure.component.converter.impl.MiniMessageComponentConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SerdesKyoriTests {

    private static final boolean    WITH_MINIMESSAGE_SUPPORT_FLAG = true;
    private static final boolean WITHOUT_MINIMESSAGE_SUPPORT_FLAG = false;

    @Test
    void verifySelectedComponentConverters() {
        assertAll(
            () -> assertTrue(new SerdesKyori(WITH_MINIMESSAGE_SUPPORT_FLAG).componentConverter instanceof MiniMessageComponentConverter),
            () -> assertTrue(new SerdesKyori(WITHOUT_MINIMESSAGE_SUPPORT_FLAG).componentConverter instanceof LegacyComponentConverter));
    }
}
