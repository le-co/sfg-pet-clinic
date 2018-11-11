package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.PetService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("map")
@Service
public class PetServiceMapImp extends AbstractMapService<Pet, Integer> implements PetService {

    @Override
    public Pet findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public void removeById(Integer id) {
        super.removeById(id);
    }

    @Override
    public List<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Pet update(Integer id, Pet object) {
        return super.update(id, object);
    }
}
