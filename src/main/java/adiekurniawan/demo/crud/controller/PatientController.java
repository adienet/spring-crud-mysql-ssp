package adiekurniawan.demo.crud.controller;


import adiekurniawan.demo.crud.entity.Patient;
import adiekurniawan.demo.crud.repository.PatientRepository;
import adiekurniawan.demo.crud.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @GetMapping("/patient")
    public Iterable<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/patient/{id}")
    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping("/patient")
    public Patient createPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PutMapping("/patient/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        return patientService.updatePatient(id, patient);
    }

    @DeleteMapping("/patient/{id}")
    public void deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
    }

}
