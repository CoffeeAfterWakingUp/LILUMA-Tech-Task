package com.liluma.olzhas_tech_task_bot.api.google.sheets.service;

import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.model.ValueRange;
import com.liluma.olzhas_tech_task_bot.api.google.sheets.properties.SheetsProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SheetsService {

    private final SheetsProperties sheetsProperties;
    private final SheetsAuthService sheetsAuthService;

    private List<List<Object>> loadSheetData() {
        try {
            Sheets service = sheetsAuthService.getSheets();
            String range = "A2:E2";
            ValueRange response = service.spreadsheets().values()
                    .get(sheetsProperties.getSpreadsheetId(), range)
                    .execute();
            return response.getValues();
        } catch (IOException | GeneralSecurityException e) {
            log.error("Exception: {}", e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
