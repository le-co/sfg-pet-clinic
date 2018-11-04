package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.service.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class SpecialityServiceMapImp extends AbstractMapService<Speciality, Integer> implements SpecialityService {
    @Override
    public Speciality findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public void removeById(Integer id) {
        super.removeById(id);
    }

    @Override
    public List<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality update(Integer id, Speciality object) {
        return super.update(id, object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }
}
