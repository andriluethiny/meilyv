package ch.noseryoung.meilyv.domain.teatype;

import ch.noseryoung.meilyv.core.generic.ExtendedEntity;
import ch.noseryoung.meilyv.domain.rank.Rank;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "teatype")
public class TeaType extends ExtendedEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "min_age")
    private Integer minAge;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "rank_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Rank rank;

    public TeaType() {
    }

    public TeaType(UUID id, String name, Integer minAge, Rank rank) {
        super(id);
        this.name = name;
        this.minAge = minAge;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public TeaType setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public TeaType setMinAge(Integer minAge) {
        this.minAge = minAge;
        return this;
    }

    public Rank getRank() {
        return rank;
    }

    public TeaType setRank(Rank rank) {
        this.rank = rank;
        return this;
    }
}