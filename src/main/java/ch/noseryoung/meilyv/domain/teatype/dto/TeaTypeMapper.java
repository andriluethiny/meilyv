package ch.noseryoung.meilyv.domain.teatype.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedMapper;
import ch.noseryoung.meilyv.domain.teatype.TeaType;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeaTypeMapper extends ExtendedMapper<TeaType, TeaTypeDTO> {
}