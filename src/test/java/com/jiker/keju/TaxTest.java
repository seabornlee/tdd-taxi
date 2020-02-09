package com.jiker.keju;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class TaxTest {
    @Test
    public void should_calculate_payment() {
        String result = new TaxPayment().calculate();
        assertThat(result).isEqualTo("收费6元\n" +
                "收费7元\n" +
                "收费13元\n" +
                "收费7元");
    }
}
