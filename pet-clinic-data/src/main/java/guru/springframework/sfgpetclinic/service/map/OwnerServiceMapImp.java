package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.service.CrudService;
import guru.springframework.sfgpetclinic.service.OwnerCrudService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Profile("map")
@Service
public class OwnerServiceMapImp extends AbstractMapService<Owner, Integer> implements OwnerCrudService {

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
        object.setId(this.id);
        return super.save(this.id, object);
    }

}
