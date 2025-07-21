package com.rk8.Internationalization_as_a_Service.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class TranslationEntry{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String key;
    private String sourceText;
    private String translatedText;
    private String targetLanguage;

    private boolean translatedByAI = false;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

}
