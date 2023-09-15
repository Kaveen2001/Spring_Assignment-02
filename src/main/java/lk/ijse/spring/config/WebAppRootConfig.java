package lk.ijse.spring.config;

import lk.ijse.spring.service.impl.ProjectServiceImpl;
import lk.ijse.spring.service.impl.TechLeadServiceImpl;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan
@EnableWebMvc
@Import({JPAConfiguration.class, TechLeadServiceImpl.class, ProjectServiceImpl.class})
public class WebAppRootConfig {

}
