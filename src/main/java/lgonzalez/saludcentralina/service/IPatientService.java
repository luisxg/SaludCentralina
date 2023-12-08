package lgonzalez.saludcentralina.service;

import lgonzalez.saludcentralina.model.Consult;
import lgonzalez.saludcentralina.model.Patient;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IPatientService {
    Patient save(Patient p);
    Patient update(Patient p);
    Patient findById(Integer id);
    List<Patient> findAll();
    void delete(Integer id);
}
