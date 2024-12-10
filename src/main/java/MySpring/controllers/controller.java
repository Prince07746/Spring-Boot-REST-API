package MySpring.controllers;

import MySpring.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import MySpring.services.PatientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/patients")
public class controller {

    private final PatientService patientService;

    @Autowired
    public controller(PatientService patientService) {
        this.patientService = patientService;
    }

    // READ
    @GetMapping
    public List<Patient> getList(){
       return patientService.getPatients();
    }
    // CREATE
    @PostMapping
    public void addPatient(@RequestBody PatientService.NewPatient patient) {
        patientService.savePatient(patient);
    }

    // DELETE
    @DeleteMapping("{patientId}")
    public void deletePatient(@PathVariable("patientId")  Integer id){
        patientService.deletePatient(id);
    }

    // UPDATE
    @PutMapping("{patientId}")
    public String updatePatient(@PathVariable("patientId") Integer id,@RequestBody PatientService.NewPatient patient){
        return patientService.updatePatient(id, patient);
    }



}
