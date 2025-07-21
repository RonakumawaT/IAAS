package com.rk8.Internationalization_as_a_Service.Repo;

import com.rk8.Internationalization_as_a_Service.Model.TranslationEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TranslationEntryRepo extends JpaRepository<TranslationEntry,Long> {
    List<TranslationEntry> findByProjectIdAndTargetLanguage(Long projectId, String targetLanguage);
}
