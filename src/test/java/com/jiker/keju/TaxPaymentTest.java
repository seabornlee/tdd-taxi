package com.jiker.keju;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class TaxPaymentTest {
    private TaxPayment taxPayment;

    @Before
    public void setUp() throws Exception {
        taxPayment = new TaxPayment();
    }

    @Test
    public void _不大于2公里时只收起步价6元() {
        long amount = taxPayment.calc(1, 0);
        assertThat(amount).isEqualTo(6);
    }

    @Test
    public void _超过2公里时每公里0点8元() {
        long amount = taxPayment.calc(7, 0);
        assertThat(amount).isEqualTo(10);
    }

    @Test
    public void _超过8公里则每公里加收百分之50长途费() {
        long amount = taxPayment.calc(7, 0);
        assertThat(amount).isEqualTo(10);
    }

    @Test
    public void _最后计价的时候司机会四舍五入只收到元() {
        long amount = taxPayment.calc(3, 0);
        assertThat(amount).isEqualTo(7);
    }
}