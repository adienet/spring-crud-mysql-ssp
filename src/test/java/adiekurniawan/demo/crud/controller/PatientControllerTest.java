package adiekurniawan.demo.crud.controller;

import adiekurniawan.demo.crud.entity.Patient;
import adiekurniawan.demo.crud.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {

    @Mock
    PatientService patientService;

    @InjectMocks
    PatientController patientController;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(patientController).build();
    }

    @Test
    public void createPatientTest() throws Exception {
        Patient patient = new Patient();
        patient.setFirstName("first");
        patient.setLastName("last");
        patient.setGender("Male");
        patient.setState("state");
        patient.setSuburb("suburb");
        patient.setPostCode("1234");
        patient.setAddress("Address");
        Mockito.when(patientService.createPatient(Mockito.any(Patient.class))).thenReturn(patient);

        mockMvc.perform(MockMvcRequestBuilders.post("/patient")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(patient)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.address", Matchers.is("Address")));

    }

    @Test
    public void editPatientTest() throws Exception {
        Patient patient = new Patient();
        patient.setFirstName("first");
        patient.setLastName("last");
        patient.setGender("Male");
        patient.setState("state");
        patient.setSuburb("suburb");
        patient.setPostCode("1234");
        patient.setAddress("Address");
        Mockito.when(patientService.updatePatient(Mockito.anyString(), Mockito.any(Patient.class))).thenReturn(patient);

        mockMvc.perform(MockMvcRequestBuilders.put("/patient/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(patient)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.address", Matchers.is("Address")));

    }

    @Test
    public void deletePatientTest() throws Exception {
        Patient patient = new Patient();
        patient.setPid("1");
        mockMvc.perform(MockMvcRequestBuilders.delete("/patient/{id}", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        Mockito.verify(patientService, Mockito.times(1)).deletePatient("1");
    }

    private String asJsonString(Object object) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


