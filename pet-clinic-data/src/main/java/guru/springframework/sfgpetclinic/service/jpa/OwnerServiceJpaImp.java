package guru.springframework.sfgpetclinic.service.jpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.service.OwnerService;
import guru.springframework.sfgpetclinic.service.PetService;
import guru.springframework.sfgpetclinic.service.map.AbstractMapService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@Profile("jpa")
public class OwnerServiceJpaImp extends AbstractMapService<Owner, Integer> implements OwnerService {

    private OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceJpaImp(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findById(Integer id) {
        return this.ownerRepository.findById(id).orElse(null);
    }

    @Override
    public void removeById(Integer id) {
        log.debug("Id to removed {} ", id);
        this.ownerRepository.deleteById(id);
    }

    @Override
    public List<Owner> findAll() {
        return (List<Owner>) this.ownerRepository.findAll();
    }

    @Override
    public Owner update(Integer id, Owner object) {
        log.debug(object.toString());

        Owner owner = this.ownerRepository.findById(id).get();

        owner.setLastName(object.getLastName());
        owner.setFirstName(object.getFirstName());
        owner.setAddress(object.getAddress());
        owner.setCity(object.getCity());
        owner.setPets(object.getPets());
        owner.setTelephone(object.getTelephone());

        return this.ownerRepository.save(owner);
    }

    @Override
    public Owner save(Owner object) {
        log.debug(object.toString());
        return this.ownerRepository.save(object);
    }

}
