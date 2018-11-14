package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
public class PetType extends BaseEntity {

    private String name;

    @OneToMany(mappedBy = "petType")
    private Set<Pet> pets;

}
