package MySpring.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Patient {
    @Id
    @SequenceGenerator(
            name = "patient_id_sequence",
            sequenceName = "patient_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "patient_id_sequence"
    )
    Integer id;
    String name;
    String surname;
    int age;
    String gender;
    String address;
    String entryDate;
    String exitDate;
    String sickness;
    String treatment;
    String doctor;
    String nurse;
    String room;
    String bed;
    public Patient(
            int id,
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
                   ) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.entryDate = entryDate;
        this.exitDate = exitDate;
        this.sickness = sickness;
        this.treatment = treatment;
        this.doctor = doctor;
        this.nurse = nurse;
        this.room = room;
        this.bed = bed;
        this.id = id;
    }
    public Patient() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public String getSickness() {
        return sickness;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return age == patient.age && Objects.equals(name, patient.name) && Objects.equals(surname, patient.surname) && Objects.equals(gender, patient.gender) && Objects.equals(address, patient.address) && Objects.equals(entryDate, patient.entryDate) && Objects.equals(exitDate, patient.exitDate) && Objects.equals(sickness, patient.sickness) && Objects.equals(treatment, patient.treatment) && Objects.equals(doctor, patient.doctor) && Objects.equals(nurse, patient.nurse) && Objects.equals(room, patient.room) && Objects.equals(bed, patient.bed) && Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, gender, address, entryDate, exitDate, sickness, treatment, doctor, nurse, room, bed, id);
    }
}
