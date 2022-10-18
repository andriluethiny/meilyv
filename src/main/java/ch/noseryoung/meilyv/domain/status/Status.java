package ch.noseryoung.meilyv.domain.status;

import ch.noseryoung.meilyv.core.generic.ExtendedEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "status")
public class Status extends ExtendedEntity {
    @Column(name = "name")
    private String name;

    public Status() {
    }

    public Status(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Status setName(String name) {
        this.name = name;
        return this;
    }
}