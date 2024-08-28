package com.liluma.olzhas_tech_task_bot.api.google.sheets.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "api.google.sheets")
public class SheetsProperties {

    private String appName;
    private String apiKey;
    private String spreadsheetId;
}
