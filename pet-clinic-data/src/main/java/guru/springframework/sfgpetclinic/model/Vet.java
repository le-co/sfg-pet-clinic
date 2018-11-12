package guru.springframework.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Vet extends Person {

    @ManyToMany
    @JoinTable(name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id", referencedColumnName = "id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }

    public void addSpeciality(Speciality speciality) {
        this.specialities.add(speciality);
    }
}
