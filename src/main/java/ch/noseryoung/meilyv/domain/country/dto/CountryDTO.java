package ch.noseryoung.meilyv.domain.country.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedDTO;

import javax.validation.constraints.Size;
import java.util.UUID;

public class CountryDTO extends ExtendedDTO {
    private String name;

    @Size(min = 2, max = 3)
    private String code;

    public CountryDTO() {
    }

    public CountryDTO(UUID id, String name, String code) {
        super(id);
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public CountryDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getCode() {
        return code;
    }

    public CountryDTO setCode(String code) {
        this.code = code;
        return this;
    }
}