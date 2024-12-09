package MySpring.controllers;

import MySpring.Patient;
import MySpring.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/patients")
public class controller {


    private final PatientRepository patientRepository;

    @Autowired
    public controller(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;

    }

    // CRUD

    // READ
    @GetMapping
    public List<Patient> getList(){
        return patientRepository.findAll();
    }
    // CREATE
    @PostMapping
    public void addPatient(@RequestBody NewPatient patient) {
        Patient patient1 = new Patient();
        patient1.setName(patient.name());
        patient1.setSurname(patient.surname());
        patient1.setAge(patient.age());
        patient1.setGender(patient.gender());
        patient1.setAddress(patient.address());
        patient1.setEntryDate(patient.entryDate());
        patient1.setExitDate(patient.exitDate());
        patient1.setSickness(patient.sickness());
        patient1.setTreatment(patient.treatment());
        patient1.setDoctor(patient.doctor());
        patient1.setNurse(patient.nurse());
        patient1.setAddress(patient.address());
        patient1.setRoom(patient.room());
        patient1.setBed(patient.bed());

        patientRepository.save(patient1);
    }

    // DELETE
    @DeleteMapping("{patientId}")
    public void deletePatient(@PathVariable("patientId")  Integer id){
        patientRepository.deleteById(id);
    }
    // UPDATE
    @PutMapping("{patientId}")
    public String updatePatient(@PathVariable("patientId") Integer id,@RequestBody NewPatient patient){

        Optional<Patient> patient1 = patientRepository.findById(id);

        if(patient1.isPresent()){

            patient1.get().setName(patient.name);
            patient1.get().setSurname(patient.surname);
            patient1.get().setAge(patient.age);

            patientRepository.save(patient1.get());

            return "Patient updated successfully";
        }else{
            return "Failed to find data with ID: "+id;
        }

    }

    static record NewPatient(

            String name,
            String surname,
            int age,
            String gender,
            String address,
            String entryDate,
            String exitDate,
            String sickness,
            String treatment,
            String doctor,
            String nurse,
            String room,
            String bed
    ){}


}
