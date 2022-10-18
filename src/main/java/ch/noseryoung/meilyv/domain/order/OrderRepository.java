package ch.noseryoung.meilyv.domain.order;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OrderRepository extends ExtendedRepository<Order> {
    List<Order> findOrdersByUserId(UUID uuid);

    @Query (value = "select t.name as name, count(t.id) as quantity from orders o left join ordertea ot on o.id = ot.order_id left join tea t on t.id = ot.tea_id left join teatype tt on t.teatype_id = tt.id where o.users_id = :users_id group by t.name", nativeQuery = true)
    Optional<List<Order>> findOwnTeaHistory(@Param("users_id") UUID usersId);

    @Query (value = "select t.name as name, count(t.id) as quantity from orders o left join ordertea ot on o.id = ot.order_id left join tea t on t.id = ot.tea_id left join teatype tt on t.teatype_id = tt.id group by t.name", nativeQuery = true)
    Optional<List<Order>> findAllTeaHistories();

    @Query(value = "select u.first_name, u.last_name, u.user_name, u.email, u.seeds, u.rank_id, sum(o.price) as expenditure from orders o left outer join users u on u.id = o.users_id left join ordertea ot on o.id = ot.order_id group by u.first_name, u.last_name, u.user_name, u.email, u.seeds, u.rank_id order by expenditure desc limit 1", nativeQuery = true)
    Optional<List<Order>> findMostBuyed();
}