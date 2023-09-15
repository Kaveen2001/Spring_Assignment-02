package lk.ijse.spring.repo;

import lk.ijse.spring.entity.TechLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TechLeadRepo extends JpaRepository<TechLead, String> {

    //select from tech_lead where tech_lead_id = ?1
    @Query("select t from TechLead t where t.techLeadId = ?1")
    TechLead findTechLead(String techLeadId);
}
