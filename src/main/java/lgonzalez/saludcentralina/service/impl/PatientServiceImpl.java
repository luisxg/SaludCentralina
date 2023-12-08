package lgonzalez.saludcentralina.service.impl;

import lgonzalez.saludcentralina.model.Consult;
import lgonzalez.saludcentralina.model.Patient;
import lgonzalez.saludcentralina.repo.IPatientRepo;
import lgonzalez.saludcentralina.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    private IPatientRepo repo;
    @Override
    public Patient save(Patient p) {
        return repo.save(p);
    }

    @Override
    public Patient update(Patient p) {
        return repo.save(p);
    }

    @Override
    public Patient findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Patient> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }


}
