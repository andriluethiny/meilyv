package ch.noseryoung.meilyv.domain.order;

import ch.noseryoung.meilyv.core.generic.ExtendedAuditEntity;
import ch.noseryoung.meilyv.domain.ordertea.OrderTea;
import ch.noseryoung.meilyv.domain.status.Status;
import ch.noseryoung.meilyv.domain.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "orders")
public class Order extends ExtendedAuditEntity {
    @Column(name = "price")
    private Float price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "users_id", referencedColumnName = "id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "status_id", referencedColumnName = "id", nullable = false)
    private Status status;

    @JsonBackReference(value = "order_ordertea")
    @OneToMany(mappedBy="order", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<OrderTea> orderTeas;

    public Order() {
    }

    public Order(UUID id, Float price, User user, Status status, Set<OrderTea> orderTeas) {
        super(id);
        this.price = price;
        this.user = user;
        this.status = status;
        this.orderTeas = orderTeas;
    }

    public Float getPrice() {
        return price;
    }

    public Order setPrice(Float price) {
        this.price = price;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public Status getStatus() {
        return status;
    }

    public Order setStatus(Status status) {
        this.status = status;
        return this;
    }

    public Set<OrderTea> getOrderTeas() {
        return orderTeas;
    }

    public Order setOrderTeas(Set<OrderTea> orderTeas) {
        this.orderTeas = orderTeas;
        return this;
    }
}