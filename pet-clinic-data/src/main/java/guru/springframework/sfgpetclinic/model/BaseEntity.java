package guru.springframework.sfgpetclinic.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date createDate;

    private Date updateDate;

    @PostUpdate
    @PostPersist
    public void dateManipulation() {
        if (this.createDate == null) {
            createDate = new Date();
        }
        updateDate = new Date();
    }
}
