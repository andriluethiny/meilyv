package ch.noseryoung.meilyv.core.generic;

import java.util.List;
import java.util.Set;

public interface ExtendedMapper<BO extends ExtendedEntity, DTO extends ExtendedDTO> {
    BO fromDTO(DTO dto);

    List<BO> fromDTOs(List<DTO> dtos);

    Set<BO> fromDTOs(Set<DTO> dtos);

    DTO toDTO(BO bo);

    List<DTO> toDTOs(List<BO> bos);

    Set<DTO> toDTOs(Set<BO> bos);
}