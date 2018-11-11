package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.service.SpecialityService;
import guru.springframework.sfgpetclinic.service.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("map")
@Service
public class VetServiceMapImp extends AbstractMapService<Vet, Integer> implements VetService {

    private SpecialityService specialityService;

    @Autowired
    public VetServiceMapImp(SpecialityService specialityService) {
        this.specialityService = specialityService;
    }

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
        if (object != null) {
            object.getSpecialities().forEach(p -> {
                if (p.getId() == null) {
                    Speciality speciality = specialityService.save(p);
                    p.setId(speciality.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet update(Integer id, Vet object) {
        return super.update(id, object);
    }
}
