package com.rk8.Internationalization_as_a_Service.Service;

import com.rk8.Internationalization_as_a_Service.DTO.ProjectRequestDTO;
import com.rk8.Internationalization_as_a_Service.Model.Project;
import com.rk8.Internationalization_as_a_Service.Model.TranslationEntry;
import com.rk8.Internationalization_as_a_Service.Repo.ProjectRepo;
import com.rk8.Internationalization_as_a_Service.Repo.TranslationEntryRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class ProjectService {

    private ProjectRepo projectRepo;
    private TranslationEntryRepo translationEntryRepo;

    public Project createProject(ProjectRequestDTO projectRequestDTO) {
        Project project = new Project();
        project.setName(projectRequestDTO.getName());
        project.setSourceLanguage(projectRequestDTO.getSourceLanguage());
        project.setCreatedAt(LocalDateTime.now());

        Project savedProject = projectRepo.save(project);

        List<TranslationEntry> entries = new ArrayList<>();
        for(Map.Entry<String,String> entry : projectRequestDTO.getEntries().entrySet()) {
            TranslationEntry translationEntry = new TranslationEntry();
            translationEntry.setKey(entry.getKey());
            translationEntry.setProject(savedProject);
            translationEntry.setSourceText(entry.getValue());
            translationEntry.setTargetLanguage(null);
            translationEntry.setTranslatedByAI(false);
            translationEntry.setTargetLanguage(null);
            entries.add(translationEntry);
        }
        translationEntryRepo.saveAll(entries);
        return savedProject;
    }
}
