package com.devops.cicd;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PricingConfigLoader {

    public PricingConfig load() throws IOException {
        Properties appProps = new Properties();

        try (InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream("app.properties")) {

            appProps.load(inputStream);
        }

        double vatRate  = Double.parseDouble(required(appProps, "vatRate"));
        double freeShippingThreshold  = Double.parseDouble(required(appProps, "freeShippingThreshold"));

        return new PricingConfig(vatRate, freeShippingThreshold);
    }

    private String required(Properties props, String key) {
        return props.getProperty(key);
    }
}