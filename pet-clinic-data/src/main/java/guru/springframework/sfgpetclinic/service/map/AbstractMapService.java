package guru.springframework.sfgpetclinic.service.map;

import com.sun.istack.internal.NotNull;
import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Integer> {

    private Map<Integer, T> map = new HashMap<>();

    T findById(ID id) {
        return this.map.get(id);
    }

    void removeById(ID id) {
        this.map.remove(id);
    }

    List<T> findAll() {
        return this.map.values().stream().collect(Collectors.toList());
    }


    T save(@NotNull T object) {
        Integer id = this.nextValue();
        object.setId(id);
        this.map.put(id, object);
        return object;
    }

    T update(ID id, T object) {
        this.removeById(id);
        return this.map.put(id, object);
    }

    Integer nextValue() {
        Integer nextId = 0;
        if (this.map.keySet() != null && this.map.keySet().size() > 0)
            nextId = Collections.max(this.map.keySet());
        return nextId + 1;
    }
}
