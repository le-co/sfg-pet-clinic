package guru.springframework.sfgpetclinic.service;

import java.util.List;

public interface ServiceBase<T, S> {

    T findById(S id);

    void removeById(S id);

    List<T> findAll();

    T save(T object);

    T update(S id, T object);
}
