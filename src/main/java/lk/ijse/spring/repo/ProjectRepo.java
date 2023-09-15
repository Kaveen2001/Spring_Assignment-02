package lk.ijse.spring.repo;

import lk.ijse.spring.entity.Projects;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Projects, String> {
}
