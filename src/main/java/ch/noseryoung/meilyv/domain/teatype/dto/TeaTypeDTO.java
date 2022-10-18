package ch.noseryoung.meilyv.domain.teatype.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedDTO;
import ch.noseryoung.meilyv.domain.rank.dto.RankDTO;

import java.util.UUID;

public class TeaTypeDTO extends ExtendedDTO {
    private String name;

    private Integer minAge;

    private RankDTO rank;

    public TeaTypeDTO() {
    }

    public TeaTypeDTO(UUID id, String name, Integer minAge, RankDTO rank) {
        super(id);
        this.name = name;
        this.minAge = minAge;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public TeaTypeDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getMinAge() {
        return minAge;
    }

    public TeaTypeDTO setMinAge(Integer minAge) {
        this.minAge = minAge;
        return this;
    }

    public RankDTO getRank() {
        return rank;
    }

    public TeaTypeDTO setRank(RankDTO rank) {
        this.rank = rank;
        return this;
    }
}