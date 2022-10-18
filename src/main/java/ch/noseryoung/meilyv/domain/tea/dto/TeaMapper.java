package ch.noseryoung.meilyv.domain.tea.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedMapper;
import ch.noseryoung.meilyv.domain.tea.Tea;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeaMapper extends ExtendedMapper<Tea, TeaDTO> {
}