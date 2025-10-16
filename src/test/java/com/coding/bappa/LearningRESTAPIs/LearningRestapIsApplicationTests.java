package com.coding.bappa.LearningRESTAPIs;

import com.coding.bappa.LearningRESTAPIs.entity.Patient;
import com.coding.bappa.LearningRESTAPIs.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LearningRestapIsApplicationTests {
	@Autowired
	private PatientRepository patientRepository;
	@Test
	void contextLoads() {
	}
	@Test
	public void patientByCity(){
		List<Patient> patients = patientRepository.findByCity("Kochi");
		for(Patient patient:patients){
			System.out.println("Patient is:" + patient);
		}
	}

}
