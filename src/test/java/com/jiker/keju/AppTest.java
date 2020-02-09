package com.jiker.keju;

import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TaxTest {
    @Test
    public void should_calculate_payment() throws IOException, URISyntaxException {
        String result = App.calculate();
        assertThat(result).isEqualTo("收费6元\n" +
                "收费7元\n" +
                "收费13元\n" +
                "收费7元");
    }
}
