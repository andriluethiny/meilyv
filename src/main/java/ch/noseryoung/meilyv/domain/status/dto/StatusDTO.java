package ch.noseryoung.meilyv.domain.status.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedDTO;

import java.util.UUID;

public class StatusDTO extends ExtendedDTO {
    private String name;

    public StatusDTO() {
    }

    public StatusDTO(UUID id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public StatusDTO setName(String name) {
        this.name = name;
        return this;
    }
}