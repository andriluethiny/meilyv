package ch.noseryoung.meilyv.domain.order.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedDTO;
import ch.noseryoung.meilyv.domain.ordertea.dto.OrderTeaDTO;
import ch.noseryoung.meilyv.domain.status.dto.StatusDTO;
import ch.noseryoung.meilyv.domain.user.dto.UserDTO;

import java.util.Set;
import java.util.UUID;

public class OrderDTO extends ExtendedDTO {
    private Float price;

    private UserDTO user;

    private StatusDTO status;

    private Set<OrderTeaDTO> orderTeas;

    public OrderDTO() {
    }

    public OrderDTO(UUID id, Float price, UserDTO user, StatusDTO status, Set<OrderTeaDTO> orderTeas) {
        super(id);
        this.price = price;
        this.user = user;
        this.status = status;
        this.orderTeas = orderTeas;
    }

    public Float getPrice() {
        return price;
    }

    public OrderDTO setPrice(Float price) {
        this.price = price;
        return this;
    }

    public UserDTO getUser() {
        return user;
    }

    public OrderDTO setUser(UserDTO user) {
        this.user = user;
        return this;
    }

    public StatusDTO getStatus() {
        return status;
    }

    public OrderDTO setStatus(StatusDTO status) {
        this.status = status;
        return this;
    }

    public Set<OrderTeaDTO> getOrderTeas() {
        return orderTeas;
    }

    public OrderDTO setOrderTeas(Set<OrderTeaDTO> orderTeas) {
        this.orderTeas = orderTeas;
        return this;
    }
}