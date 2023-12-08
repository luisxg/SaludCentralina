package lgonzalez.saludcentralina.repo;

import lgonzalez.saludcentralina.model.Patient;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepo extends IGenericRepo<Patient, Integer> {
}
