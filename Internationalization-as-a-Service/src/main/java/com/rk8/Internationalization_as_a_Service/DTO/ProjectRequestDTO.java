package com.rk8.Internationalization_as_a_Service.DTO;

import lombok.Data;

import java.util.Map;

@Data
public class ProjectRequestDTO {
    private String name;
    private String sourceLanguage;
    Map<String, String> entries;
}
