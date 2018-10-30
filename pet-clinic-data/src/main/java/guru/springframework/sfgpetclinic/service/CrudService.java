package guru.springframework.sfgpetclinic.service;

import java.util.List;

public interface CrudService<T, ID> {

    T findById(ID id);

    void removeById(ID id);

    List<T> findAll();

    T save(T object);

    T update(ID id, T object);
}
