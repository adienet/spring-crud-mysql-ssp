package adiekurniawan.demo.crud.service;

import adiekurniawan.demo.crud.entity.Patient;
import adiekurniawan.demo.crud.repository.PatientRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {
    @InjectMocks
    private PatientService patientService;

    @Mock
    private PatientRepository patientRepository;

    @Test
    public void testCreate() {
        Patient entityToCreate = new Patient();
        entityToCreate.setFirstName("Test Name");

        Mockito.when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(entityToCreate);

        Patient createdEntity = patientService.createPatient(entityToCreate);

        Assert.assertNotNull(createdEntity);
        Assert.assertEquals("Test Name", createdEntity.getFirstName());

        Mockito.verify(patientRepository, Mockito.times(1)).save(Mockito.any(Patient.class));
    }

    @Test
    public void testUpdate() {
        Patient existingEntity = new Patient();
        existingEntity.setPid("1");
        existingEntity.setFirstName("Existing Name");

        Patient updatedEntity = new Patient();
        updatedEntity.setPid("1");
        updatedEntity.setFirstName("Updated Name");

        Mockito.when(patientRepository.findById(Mockito.anyString())).thenReturn(Optional.of(existingEntity));
        Mockito.when(patientRepository.save(Mockito.any(Patient.class))).thenReturn(updatedEntity);

        Patient result = patientService.updatePatient("1", updatedEntity);

        Assert.assertNotNull(result);
        Assert.assertEquals("Updated Name", result.getFirstName());

        Mockito.verify(patientRepository, Mockito.times(1)).findById(Mockito.anyString());
        Mockito.verify(patientRepository, Mockito.times(1)).save(Mockito.any(Patient.class));
    }

    @Test
    public void testDelete() {
        Patient existingEntity = new Patient();
        existingEntity.setPid("1");
        existingEntity.setFirstName("Test Name");

        patientService.deletePatient("1");

        Mockito.verify(patientRepository, Mockito.times(1)).deleteById(Mockito.anyString());
    }

}
