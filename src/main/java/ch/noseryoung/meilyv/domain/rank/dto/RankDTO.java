package ch.noseryoung.meilyv.domain.rank.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedDTO;

import java.util.UUID;

public class RankDTO extends ExtendedDTO {
    private String name;

    private Integer seeds;

    private Float discount;

    public RankDTO() {
    }

    public RankDTO(UUID id, String name, Integer seeds, Float discount) {
        super(id);
        this.name = name;
        this.seeds = seeds;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public RankDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getSeeds() {
        return seeds;
    }

    public RankDTO setSeeds(Integer seeds) {
        this.seeds = seeds;
        return this;
    }

    public Float getDiscount() {
        return discount;
    }

    public RankDTO setDiscount(Float discount) {
        this.discount = discount;
        return this;
    }
}