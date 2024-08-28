package com.liluma.olzhas_tech_task_bot.api.google.sheets.service;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsRequestInitializer;
import com.liluma.olzhas_tech_task_bot.api.google.sheets.properties.SheetsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Service
@RequiredArgsConstructor
public class SheetsAuthService {

    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private final SheetsProperties sheetsProperties;

    public Sheets getSheets() throws GeneralSecurityException, IOException {
        return new Sheets.Builder(
                GoogleNetHttpTransport.newTrustedTransport(),
                JSON_FACTORY,
                null)
                .setApplicationName(sheetsProperties.getAppName())
                .setSheetsRequestInitializer(new SheetsRequestInitializer(sheetsProperties.getApiKey())).build();
    }

}
