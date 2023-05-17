package adiekurniawan.demo.crud.controller;

import adiekurniawan.demo.crud.entity.PatientData;
import adiekurniawan.demo.crud.service.PatientDataService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PatientDataController {

    @Autowired
    PatientDataService patientDataService;

    @GetMapping(value = "/ssp/api")
    public DataTablesOutput<PatientData> list(@Valid DataTablesInput input) {
        return patientDataService.findAll(input);
    }

    @PostMapping(value = "/ssp/api")
    public DataTablesOutput<PatientData> listPOST(@Valid @RequestBody DataTablesInput input) {
        return patientDataService.findAll(input);
    }

}
