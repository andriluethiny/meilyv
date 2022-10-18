package ch.noseryoung.meilyv.domain.ordertea;

import ch.noseryoung.meilyv.core.generic.ExtendedEntity;
import ch.noseryoung.meilyv.domain.order.Order;
import ch.noseryoung.meilyv.domain.tea.Tea;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "ordertea")
public class OrderTea extends ExtendedEntity {
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tea_id", referencedColumnName = "id", updatable = false, nullable = false)
    private Tea tea;

    public OrderTea() {
    }

    public OrderTea(UUID id, Integer quantity, Order order, Tea tea) {
        super(id);
        this.quantity = quantity;
        this.order = order;
        this.tea = tea;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public OrderTea setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public Order getOrder() {
        return order;
    }

    public OrderTea setOrder(Order order) {
        this.order = order;
        return this;
    }

    public Tea getTea() {
        return tea;
    }

    public OrderTea setTea(Tea tea) {
        this.tea = tea;
        return this;
    }
}