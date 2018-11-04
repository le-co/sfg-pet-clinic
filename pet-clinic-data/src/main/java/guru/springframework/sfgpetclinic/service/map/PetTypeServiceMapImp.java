package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class PetTypeServiceMapImp extends AbstractMapService<PetType, Integer> implements PetTypeService {
    @Override
    public PetType findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public void removeById(Integer id) {
        super.removeById(id);
    }

    @Override
    public List<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType update(Integer id, PetType object) {
        return super.update(id, object);
    }

    @Override
    public PetType save(PetType object) {
        return super.save(object);
    }
}
