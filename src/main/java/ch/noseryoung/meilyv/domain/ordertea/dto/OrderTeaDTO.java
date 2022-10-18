package ch.noseryoung.meilyv.domain.ordertea.dto;

import ch.noseryoung.meilyv.core.generic.ExtendedDTO;
import ch.noseryoung.meilyv.domain.tea.dto.TeaDTO;

import java.util.UUID;

public class OrderTeaDTO extends ExtendedDTO {
    private Integer quantity;

    private TeaDTO tea;

    public OrderTeaDTO() {
    }

    public OrderTeaDTO(UUID id, Integer quantity, TeaDTO tea) {
        super(id);
        this.quantity = quantity;
        this.tea = tea;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderTeaDTO setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public TeaDTO getTea() {
        return tea;
    }

    public OrderTeaDTO setTea(TeaDTO tea) {
        this.tea = tea;
        return this;
    }
}