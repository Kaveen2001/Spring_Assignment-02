package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TechLead {

    @Id
    private String techLeadId;
    private String techLeadName;
    private String techLeadEmail;
    private String techLeadAddress;

    @OneToMany(mappedBy = "techLeadId" ,targetEntity = Projects.class,cascade = CascadeType.ALL)
    private List<Projects>projectsList = new ArrayList<>();
}
