package ch.noseryoung.meilyv.domain.order;

import ch.noseryoung.meilyv.core.generic.ExtendedService;

import java.util.List;

public interface OrderService extends ExtendedService<Order> {
    List<Order> findOrdersByUserId();

    Order createOrder(Order order);

    List<Order> findOwnTeaHistory();

    List<Order> findAllTeaHistories();

    List<Order> findMostBuyed();
}