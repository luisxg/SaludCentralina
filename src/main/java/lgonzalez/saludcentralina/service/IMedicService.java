package lgonzalez.saludcentralina.service;

import lgonzalez.saludcentralina.model.Medic;

import java.util.List;

public interface IMedicService {
    Medic save(Medic m);
    Medic update(Medic m);
    Medic findById(Integer id);
    List<Medic> findAll();
    void delete(Integer id);
}
