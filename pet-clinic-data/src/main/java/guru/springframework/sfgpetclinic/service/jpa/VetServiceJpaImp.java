package guru.springframework.sfgpetclinic.service.jpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.repositories.VetRepository;
import guru.springframework.sfgpetclinic.service.SpecialityService;
import guru.springframework.sfgpetclinic.service.VetService;
import guru.springframework.sfgpetclinic.service.map.AbstractMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("jpa")
@Service
public class VetServiceJpaImp implements VetService {


    private VetRepository vetRepository;

    @Autowired
    public VetServiceJpaImp(VetRepository vetRepository) {
        this.vetRepository = vetRepository;
    }

    @Override
    public Vet findById(Integer id) {
        return this.vetRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        this.vetRepository.deleteById(id);
    }

    @Override
    public List<Vet> findAll() {
        return (List<Vet>) this.vetRepository.findAll();
    }

    @Override
    public Vet save(Vet object) {
        return this.vetRepository.save(object);
    }

    @Override
    public Vet update(Integer id, Vet object) {
        Vet vetFound = this.vetRepository.findById(id).get();
        vetFound.setSpecialities(object.getSpecialities());
        vetFound.setFirstName(object.getFirstName());
        vetFound.setLastName(object.getLastName());
        return this.vetRepository.save(vetFound);
    }
}
