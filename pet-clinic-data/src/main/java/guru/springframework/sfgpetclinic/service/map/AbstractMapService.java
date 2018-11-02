package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.service.CrudService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<>();

    T findById(ID id) {
        return this.map.get(id);
    }

    void removeById(ID id) {
        this.map.remove(id);
    }

    List<T> findAll() {
        return this.map.values().stream().collect(Collectors.toList());
    }

    T save(ID id, T object) {
        return this.map.put(id, object);
    }

    T update(ID id, T object) {
        this.removeById(id);
        return this.save(id, object);
    }
}
