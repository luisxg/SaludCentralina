package lgonzalez.saludcentralina.service.impl;

import lgonzalez.saludcentralina.model.Medic;
import lgonzalez.saludcentralina.repo.IMedicRepo;
import lgonzalez.saludcentralina.service.IMedicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicServiceImpl implements IMedicService{

    @Autowired
    private IMedicRepo repo;
    @Override
    public Medic save(Medic m) {
        return repo.save(m);
    }

    @Override
    public Medic update(Medic m) {
        return repo.save(m);
    }

    @Override
    public Medic findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Medic> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Integer id) {
        repo.deleteById(id);
    }
}
