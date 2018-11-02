package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.CrudService;
import guru.springframework.sfgpetclinic.service.VetCrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("map")
@Service
public class VetServiceMapImp extends AbstractMapService<Vet, Integer> implements VetCrudService {

    @Override
    public Vet findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public void removeById(Integer id) {
        super.removeById(id);
    }

    @Override
    public List<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet save(Vet object) {
        return super.save(object);
    }

    @Override
    public Vet update(Integer id, Vet object) {
        return super.update(id, object);
    }
}
