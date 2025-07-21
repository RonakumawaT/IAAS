package com.rk8.Internationalization_as_a_Service.Response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranslationResponse {
    private String translatedText;
    private String targetLanguage;
}
