package MySpring.repositories;

import MySpring.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public  interface PatientRepository extends JpaRepository<Patient, Integer> {
}
