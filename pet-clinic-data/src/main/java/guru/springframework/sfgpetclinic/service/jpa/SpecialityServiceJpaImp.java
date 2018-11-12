package guru.springframework.sfgpetclinic.service.jpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.service.SpecialityService;
import guru.springframework.sfgpetclinic.service.map.AbstractMapService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("jpa")
public class SpecialityServiceJpaImp implements SpecialityService {

    private SpecialityRepository specialityRepository;

    public SpecialityServiceJpaImp(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Speciality findById(Integer id) {
        return this.specialityRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        this.specialityRepository.deleteById(id);
    }

    @Override
    public List<Speciality> findAll() {
        return (List<Speciality>) this.specialityRepository.findAll();
    }

    @Override
    public Speciality update(Integer id, Speciality object) {
        Speciality speciality = this.specialityRepository.findById(id).get();
        speciality.setDescription(object.getDescription());
        return this.specialityRepository.save(speciality);
    }

    @Override
    public Speciality save(Speciality object) {
        return this.specialityRepository.save(object);
    }
}
