package ch.noseryoung.meilyv.domain.rank;

import ch.noseryoung.meilyv.core.generic.ExtendedAuditEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "rank")
public class Rank extends ExtendedAuditEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "seeds")
    private Integer seeds = 0;

    @Column(name = "discount")
    private Float discount;

    public Rank() {
    }

    public Rank(UUID id, String name, Integer seeds, Float discount) {
        super(id);
        this.name = name;
        this.seeds = seeds;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public Rank setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSeeds() {
        return seeds;
    }

    public Rank setSeeds(Integer seeds) {
        this.seeds = seeds;
        return this;
    }

    public Float getDiscount() {
        return discount;
    }

    public Rank setDiscount(Float discount) {
        this.discount = discount;
        return this;
    }
}