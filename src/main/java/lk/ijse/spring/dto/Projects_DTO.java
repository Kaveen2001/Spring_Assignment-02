package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Projects_DTO implements Serializable, Super_DTO {

    private String projectId;
    private String projectName;
    private String projectDescription;
    private String projectDeadline;
    private String techLeadId;
}
