package guru.springframework.sfgpetclinic.service.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractMapService<T, ID> {

    protected Integer id = 1;

    private Map<ID, T> map = new HashMap<>();

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
        this.map.put(id, object);
        this.nextValue();
        return object;
    }

    T update(ID id, T object) {
        this.removeById(id);
        return this.save(id, object);
    }

    void nextValue() {
        List<BaseEntity> entities = (List<BaseEntity>) this.findAll();
        if (entities != null)
            for (BaseEntity entity : entities) {
                id = entity.getId() > id ? entity.getId() : id;
            }
        id++;
    }
}
