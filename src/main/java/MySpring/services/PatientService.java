package MySpring.services;


import MySpring.model.Patient;
import MySpring.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {


    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

//    CRUD OPERATION

    //    CREATE
    public void savePatient(NewPatient patientNew) {
        Patient patient = new Patient();
        patient.setName(patientNew.name());
        patient.setSurname(patientNew.surname());
        patient.setAge(patientNew.age());
        patient.setGender(patientNew.gender());
        patient.setAddress(patientNew.address());
        patient.setEntryDate(patientNew.entryDate());
        patient.setExitDate(patientNew.exitDate());
        patient.setSickness(patientNew.sickness());
        patient.setTreatment(patientNew.treatment());
        patient.setDoctor(patientNew.doctor());
        patient.setAge(patientNew.age());
        patient.setNurse(patientNew.nurse());
        patient.setRoom(patientNew.room());
        patient.setBed(patientNew.bed());
        patientRepository.save(patient);
    }


    //    READ
    public List<Patient>  getPatients(){
        return patientRepository.findAll();
    }


    //    UPDATE
    public String updatePatient(Integer id, NewPatient patient){

        Optional<Patient> patient1 = patientRepository.findById(id);
        if(patient1.isPresent()){

            patient1.get().setName(patient.name());
            patient1.get().setSurname(patient.surname());
            patient1.get().setAge(patient.age());

            patientRepository.save(patient1.get());
            return "Successfully updated data with ID: " + id;
        }else{
            return "Failed to find data with ID: " + id;
        }
    }


    //    DELETE
    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }


    //    RECORD

    public static record NewPatient(

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
