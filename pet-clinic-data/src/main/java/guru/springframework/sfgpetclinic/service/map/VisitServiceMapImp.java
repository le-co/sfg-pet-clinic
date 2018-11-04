package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("map")
public class VisitServiceMapImp extends AbstractMapService<Visit, Integer> implements VisitService {
    @Override
    public Visit findById(Integer id) {
        return super.findById(id);
    }

    @Override
    public void removeById(Integer id) {
        super.removeById(id);
    }

    @Override
    public List<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit update(Integer id, Visit object) {
        return super.update(id, object);
    }

    @Override
    public Visit save(Visit object) {
        return super.save(object);
    }
}
