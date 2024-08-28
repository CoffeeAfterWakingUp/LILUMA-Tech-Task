package com.liluma.olzhas_tech_task_bot.utils;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

@Slf4j
@UtilityClass
public class PropertiesReader {

    public Properties getProperties() {
        Properties properties = new Properties();
        try {
            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("message_ru.properties");

            if (input != null) {
                properties.load(new InputStreamReader(input, StandardCharsets.UTF_8));
            }
        } catch (IOException e) {
            log.error("Exception in PropertiesReader getProperties: {}", e.getMessage());
            e.printStackTrace();
        }
        return properties;
    }
}
