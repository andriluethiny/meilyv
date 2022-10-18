package ch.noseryoung.meilyv.domain.rank.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedMapper;
import ch.noseryoung.meilyv.domain.rank.Rank;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RankMapper extends ExtendedMapper<Rank, RankDTO> {
}