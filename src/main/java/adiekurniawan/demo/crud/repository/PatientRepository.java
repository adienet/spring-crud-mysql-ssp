package adiekurniawan.demo.crud.repository;

import adiekurniawan.demo.crud.entity.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends CrudRepository<Patient, String> {



}
