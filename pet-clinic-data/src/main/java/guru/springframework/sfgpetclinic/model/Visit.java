package guru.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Visit extends BaseEntity {

    private LocalDate date;

    private String description;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private Pet pet;
}
