package adiekurniawan.demo.crud.service;

import adiekurniawan.demo.crud.entity.Patient;
import adiekurniawan.demo.crud.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(@PathVariable Long id) {
        return patientRepository.findById(id);
    }

    public Patient createPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
        Optional<Patient> existingPatient = patientRepository.findById(id);

        if (existingPatient.isPresent()) {
            Patient updatePatient = existingPatient.get();
            updatePatient.setFirstName(patient.getFirstName());
            updatePatient.setLastName(patient.getLastName());
            updatePatient.setDateOfBirth(patient.getDateOfBirth());
            updatePatient.setGender(patient.getGender());
            updatePatient.setAddress(patient.getAddress());
            updatePatient.setSuburb(patient.getSuburb());
            updatePatient.setState(patient.getState());
            updatePatient.setPostCode(patient.getPostCode());
            return patientRepository.save(updatePatient);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found");
        }
    }

    public void deletePatient(@PathVariable Long id) {
        patientRepository.deleteById(id);
    }
}
