package guru.springframework.sfgpetclinic.service.jpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.service.PetTypeService;
import guru.springframework.sfgpetclinic.service.map.AbstractMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("jpa")
public class PetTypeServiceJpaImp implements PetTypeService {

    private PetTypeRepository petTypeRepository;

    @Autowired
    public PetTypeServiceJpaImp(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public PetType findById(Integer id) {
        return this.petTypeRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        this.petTypeRepository.deleteById(id);
    }

    @Override
    public List<PetType> findAll() {
        return (List<PetType>) this.petTypeRepository.findAll();
    }

    @Override
    public PetType update(Integer id, PetType object) {
        PetType petType = this.petTypeRepository.findById(id).get();
        petType.setName(object.getName());
        petType.setPets(object.getPets());
        return this.petTypeRepository.save(petType);
    }

    @Override
    public PetType save(PetType object) {
        return this.petTypeRepository.save(object);
    }
}
