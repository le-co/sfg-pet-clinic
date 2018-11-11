package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("map")
@Service
public class OwnerServiceMapImp extends AbstractMapService<Owner, Integer> implements OwnerService {

    private PetService petService;

    @Autowired
    public OwnerServiceMapImp(PetService petService) {
        this.petService = petService;
    }

    @Override
    public Owner findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public void removeById(Integer id) {
        super.removeById(id);
    }

    @Override
    public List<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner update(Integer id, Owner object) {
        return super.update(id, object);
    }

    @Override
    public Owner save(Owner object) {
        if (object != null) {
            object.getPets().forEach(p -> {
                if (p.getPetType() != null) {
                    if (p.getPetType().getId() == null) {

                    }
                } else {
                    throw new RuntimeException("Pet type is required");
                }
                if (p.getId() == null) {
                    Pet savedPet = petService.save(p);
                    p.setId(savedPet.getId());
                }
            });
        }
        return super.save(object);
    }

}
