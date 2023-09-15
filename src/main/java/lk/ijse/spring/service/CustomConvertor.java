package lk.ijse.spring.service;

import lk.ijse.spring.dto.Projects_DTO;
import lk.ijse.spring.entity.Projects;

public class CustomConvertor {
    public static Projects_DTO toProjectsDTO(Projects project){
        return new Projects_DTO(project.getProjectId(),project.getProjectName(),project.getProjectDescription(),project.getProjectDeadline(),project.getTechLeadId().getTechLeadId());
    }
}
