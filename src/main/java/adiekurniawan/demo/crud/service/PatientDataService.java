package adiekurniawan.demo.crud.service;


import adiekurniawan.demo.crud.entity.PatientData;
import adiekurniawan.demo.crud.repository.PatientDataRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;


@Service
public class PatientDataService {
    @Autowired
    PatientDataRepository patientDataRepository;

    public DataTablesOutput<PatientData> findAll(@Valid DataTablesInput input) {
        return patientDataRepository.findAll(input);
    }
}
