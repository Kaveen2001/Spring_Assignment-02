package lk.ijse.spring.endpoints;

import lk.ijse.spring.dto.TechLead_DTO;
import lk.ijse.spring.response.Response;
import lk.ijse.spring.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/techLead")
@CrossOrigin

public class TechLeadController {

    @Autowired
    private TechLeadService techLeadService;

    @PostMapping(path = "/save", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Response save(@RequestBody TechLead_DTO techLead_dto) {
        return techLeadService.save(techLead_dto);
    }

    @PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

    public Response update(@RequestBody TechLead_DTO techLead_dto) {
        return techLeadService.update(techLead_dto);
    }

    @GetMapping(path = "/search", params = "techLeadId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response search(@RequestParam("techLeadId") String techLeadId) {
        return techLeadService.search(techLeadId);
    }

    @DeleteMapping(path = "/delete", params = "techLeadId", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response delete(@RequestParam("techLeadId") String techLeadId) {
        return techLeadService.delete(techLeadId);
    }

    @GetMapping(path = "/fetchAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAll() {
        return techLeadService.getAll();
    }
}
