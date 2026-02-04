package com.example.hospitalManagement;

import com.example.hospitalManagement.entity.Patient;
import com.example.hospitalManagement.entity.type.BloodGroupType;
import com.example.hospitalManagement.repository.PatientRepository;
import com.example.hospitalManagement.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

//    @Test
//    public void testPatientRepository(){
//
//        Patient p1 = new Patient();
//        patientRepository.save(p1);
//    }

    @Test
    public void testTransactionMethod(){
//        Patient patient = patientRepository.findByName("Diya Patel");

//        List<Patient> patientList = patientRepository.findByBirthDateOrEmail(LocalDate.of(1988, 3, 15), "diya.patel@example.com");

//        List<Patient> patientList = patientRepository.findByByBornAfterDate(LocalDate.of(1993, 3, 14));

        List<Patient> patientList = patientRepository.findAllPatients();

        for (Patient patient: patientList){
            System.out.println(patient);
        }

        List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
        for(Object[] objects: bloodGroupList){
            System.out.println(objects[0] + " " + objects[1]);
        }

        int rowsUpdated = patientRepository.updateNameWithId("Arav", 1L);
        System.out.println(rowsUpdated);
    }
}
