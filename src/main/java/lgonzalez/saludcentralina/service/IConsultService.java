package lgonzalez.saludcentralina.service;

import lgonzalez.saludcentralina.model.Consult;

import java.util.List;

public interface IConsultService {
    Consult save(Consult c);
    Consult update(Consult c);
    Consult findById(Integer id);
    List<Consult> findAll();

    void delete(Integer id);
    Consult saveTransactional(Consult consult);

}
