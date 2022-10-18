package ch.noseryoung.meilyv.domain.authority;

import ch.noseryoung.meilyv.core.generic.ExtendedAuditEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "authority")
public class Authority extends ExtendedAuditEntity {

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Authority() {
    }

    public Authority(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Authority setName(String name) {
        this.name = name;
        return this;
    }
}