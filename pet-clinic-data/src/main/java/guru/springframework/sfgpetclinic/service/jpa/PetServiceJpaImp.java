package guru.springframework.sfgpetclinic.service.jpa;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.PetRepository;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.map.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("jpa")
@Service
public class PetServiceJpaImp implements PetService {

    private PetRepository petRepository;

    public PetServiceJpaImp(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public Pet findById(Integer id) {
        return this.petRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        this.petRepository.deleteById(id);
    }

    @Override
    public List<Pet> findAll() {
        return (List<Pet>) this.petRepository.findAll();
    }

    @Override
    public Pet save(Pet object) {
        return this.petRepository.save(object);
    }

    @Override
    public Pet update(Integer id, Pet object) {
        Pet pet = this.petRepository.findById(id).get();

        pet.setPetType(object.getPetType());
        pet.setName(object.getName());
        pet.setBirthDate(object.getBirthDate());
        pet.setVisits(object.getVisits());
        pet.setOwner(object.getOwner());

        return this.petRepository.save(pet);
    }
}
