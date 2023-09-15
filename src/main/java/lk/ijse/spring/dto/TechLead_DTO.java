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
public class TechLead_DTO implements Serializable,Super_DTO {

    private String techLeadId;
    private String techLeadName;
    private String techLeadEmail;
    private String techLeadAddress;
}
