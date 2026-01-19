package com.devops.cicd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PricingServiceTest {

    private final PricingConfig fakeConfig = new PricingConfig(20.0, 50.0);
    private final PricingService service = new PricingService(fakeConfig);

    @Test
    void testApplyVat() {
        double amountExclVat = 150.0;
        double amountWithVat = service.applyVat(amountExclVat);

        assertEquals(amountExclVat * (1 + 20.0 / 100), amountWithVat);
    }

    @Test
    void testApplyVipDiscount_whenIsVip_thenApplyVipDiscount() {
        double amount = 150.0;
        double amountWithVipDiscount = service.applyVipDiscount(amount, true);

        assertEquals(amount * 0.9, amountWithVipDiscount);
    }

    @Test
    void testApplyVipDiscount_whenIsNotVip_thenNotApplyVipDiscount() {
        double amount = 150.0;
        double amountWithVipDiscount = service.applyVipDiscount(amount, false);

        assertEquals(amount, amountWithVipDiscount);
    }

    @Test
    void testShippingCost_whenAmountIsMoreThanFreeShippingThreshold_thenFree() {
        double amount = 50.0;
        double shippingCost = service.shippingCost(amount);

        assertEquals(0, shippingCost);
    }

    @Test
    void testShippingCost_whenAmountIsLessThanFreeShippingThreshold_thenNotFree() {
        double amount = 25.0;
        double shippingCost = service.shippingCost(amount);

        assertEquals(4.99, shippingCost);
    }

    @Test
    void testFinalTotal() {
        double amount = 100.0;
        double total = service.finalTotal(amount, false);

        assertEquals(120, total);
    }
}