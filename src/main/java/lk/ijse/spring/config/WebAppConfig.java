package lk.ijse.spring.config;

import lk.ijse.spring.advisor.ApplicationAdvisor;
import lk.ijse.spring.endpoints.TechLeadController;
import lk.ijse.spring.response.Response;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = {Response.class, ApplicationAdvisor.class, TechLeadController.class})
@EnableWebMvc
public class WebAppConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
