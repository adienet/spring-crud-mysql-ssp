package adiekurniawan.demo.crud.repository;

import adiekurniawan.demo.crud.entity.PatientData;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDataRepository extends DataTablesRepository<PatientData, Integer> {

}
