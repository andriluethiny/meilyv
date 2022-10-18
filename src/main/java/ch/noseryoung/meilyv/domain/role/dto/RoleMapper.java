package ch.noseryoung.meilyv.domain.role.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedMapper;
import ch.noseryoung.meilyv.domain.role.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper extends ExtendedMapper<Role, RoleDTO> {
}
