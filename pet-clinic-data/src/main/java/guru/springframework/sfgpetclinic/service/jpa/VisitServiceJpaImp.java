package guru.springframework.sfgpetclinic.service.jpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import guru.springframework.sfgpetclinic.service.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("jpa")
public class VisitServiceJpaImp implements VisitService {

    private VisitRepository visitRepository;

    public VisitServiceJpaImp(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit findById(Integer id) {
        return this.visitRepository.findById(id).get();
    }

    @Override
    public void removeById(Integer id) {
        this.visitRepository.deleteById(id);
    }

    @Override
    public List<Visit> findAll() {
        return (List<Visit>) this.visitRepository.findAll();
    }

    @Override
    public Visit update(Integer id, Visit object) {
        Visit visitFound = this.visitRepository.findById(id).get();
        visitFound.setDescription(object.getDescription());
        visitFound.setPet(object.getPet());
        return this.visitRepository.save(visitFound);
    }

    @Override
    public Visit save(Visit object) {
        return this.visitRepository.save(object);
    }
}
