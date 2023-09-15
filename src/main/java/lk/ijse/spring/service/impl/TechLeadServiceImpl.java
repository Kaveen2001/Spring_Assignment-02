package lk.ijse.spring.service.impl;

import lk.ijse.spring.dto.TechLead_DTO;
import lk.ijse.spring.entity.TechLead;
import lk.ijse.spring.repo.TechLeadRepo;
import lk.ijse.spring.response.Response;
import lk.ijse.spring.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {

    @Autowired
    private TechLeadRepo techLeadRepo;

    @Autowired
    private Response response;

    @Autowired
    private ModelMapper mapper;

    @Override
    public Response save(TechLead_DTO techLeadDto) {
        if (search(techLeadDto.getTechLeadId()).getData() == null) {
            techLeadRepo.save(mapper.map(techLeadDto, TechLead.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Employee Successfully saved!", null);
        }
        throw new RuntimeException("Employee already exists!");
    }

    @Override
    public Response update(TechLead_DTO techLeadDto) {
        if (search(techLeadDto.getTechLeadId()).getData() != null) {
            techLeadRepo.save(mapper.map(techLeadDto, TechLead.class));
            return createAndSendResponse(HttpStatus.OK.value(), "Employee Successfully updated!", null);
        }
        throw new RuntimeException("Employee does not exists!");
    }

    @Override
    public Response delete(String s) {
        if (search(s).getData() != null) {
            techLeadRepo.deleteById(s);
            return createAndSendResponse(HttpStatus.OK.value(), "Employee Successfully deleted!", null);
        }
        throw new RuntimeException("Employee does not exists!");
    }

    @Override
    public Response search(String s) {
        Optional<TechLead> techLead = techLeadRepo.findById(s);
        if (techLead.isPresent()) {
            return createAndSendResponse(HttpStatus.FOUND.value(), "Employee Successfully retrieved!", mapper.map(techLead.get(), TechLead_DTO.class));
        }
        return createAndSendResponse(HttpStatus.NOT_FOUND.value(), "Employee doe not exists!", null);
    }

    @Override
    public Response getAll() {
        List<TechLead> techLeads = techLeadRepo.findAll();
        if (!techLeads.isEmpty()) {
            ArrayList<TechLead_DTO> techLead_dtos = new ArrayList<>();
            techLeads.forEach((techLead) -> {
                techLead_dtos.add(mapper.map(techLead, TechLead_DTO.class));

            });
            return createAndSendResponse(HttpStatus.FOUND.value(), "Employees Successfully retrieved!", techLead_dtos);
        }
        throw new RuntimeException("No employees found in the database!");
    }

    @Override
    public Response createAndSendResponse(int statusCode, String message, Object data) {
        response.setStatusCode(statusCode);
        response.setMessage(message);
        response.setData(data);
        return response;
    }
}
