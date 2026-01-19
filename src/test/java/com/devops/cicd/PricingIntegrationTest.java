package com.devops.cicd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class PricingIntegrationTest {

    @Test
    void fullPricingFlow_withRealConfigFile() throws IOException {
        PricingConfigLoader loader = new PricingConfigLoader();
        PricingConfig config = loader.load();

        PricingService service = new PricingService(config);

        Assertions.assertEquals(108, service.finalTotal(100d, true));
    }
}