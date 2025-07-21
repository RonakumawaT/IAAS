package com.rk8.Internationalization_as_a_Service.Controller;

import com.rk8.Internationalization_as_a_Service.DTO.ProjectRequestDTO;
import com.rk8.Internationalization_as_a_Service.Model.Project;
import com.rk8.Internationalization_as_a_Service.Service.ProjectService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/projects")
@AllArgsConstructor
public class ProjectController {

    private ProjectService projectService;

    @PostMapping()
    public ResponseEntity<Project> createProject(@RequestBody ProjectRequestDTO project) {
        Project createdProject = projectService.createProject(project);
        return ResponseEntity.ok(createdProject);
    }
}
