package ch.noseryoung.meilyv.domain.order.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedMapper;
import ch.noseryoung.meilyv.domain.order.Order;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper extends ExtendedMapper<Order, OrderDTO> {
}