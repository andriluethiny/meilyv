package ch.noseryoung.meilyv.domain.country;

import ch.noseryoung.meilyv.core.generic.ExtendedEntity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "country")
public class Country extends ExtendedEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    public Country() {
    }

    public Country(UUID id, String name, String code) {
        super(id);
        this.name = name;
        this.code = code;
    }

    public Country setId(UUID id) {
        super.setId(id);
        return this;
    }


    public String getName() {
        return name;
    }

    public Country setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Country setCode(String code) {
        this.code = code;
        return this;
    }
}