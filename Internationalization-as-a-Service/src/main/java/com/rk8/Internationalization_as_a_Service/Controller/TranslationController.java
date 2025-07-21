package com.rk8.Internationalization_as_a_Service.Controller;

import com.rk8.Internationalization_as_a_Service.Response.TranslationResponse;
import com.rk8.Internationalization_as_a_Service.Service.GeminiService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/translate")
public class TranslationController {

    @Autowired
    private GeminiService geminiService;

    @PostMapping("/ai")
    public ResponseEntity<TranslationResponse> translateUsingGemini(@Valid  @RequestBody TranslateRequest request) {
        String translatedText = geminiService.translate(request.getText(), request.getTargetLanguage());
        TranslationResponse response = new TranslationResponse(translatedText, request.getTargetLanguage());
        return ResponseEntity.ok(response);
    }

    @Data
    public static class TranslateRequest {

        @NotBlank(message = "Text to translate cannot be blank")
        private String text;

        @NotBlank(message = "Target language cannot be blank")
        private String targetLanguage;
    }
}
