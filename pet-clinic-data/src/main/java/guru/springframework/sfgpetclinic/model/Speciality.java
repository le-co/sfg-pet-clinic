package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Speciality extends BaseEntity {

    private String description;

    @ManyToMany(mappedBy = "specialities")
    private Set<Vet> vets = new HashSet<>();

}
