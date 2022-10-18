package ch.noseryoung.meilyv.domain.user;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.domain.user.dto.UserDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends ExtendedRepository<User> {
    Optional<User> findByEmail(String email);

    @Query(value = "select u.first_name, u.last_name, u.user_name, u.email, u.seeds, u.rank_id, sum(o.price / r.discount - o.price) as discount from users u left join rank r on r.id = u.rank_id left join orders o on u.id = o.users_id left join tea t on o.price = t.selling_price where o.created_at >= current_date - ( :time_span )\\:\\:interval group by u.first_name, u.last_name, u.user_name, u.email, u.seeds, u.rank_id", nativeQuery = true)
    Optional<List<UserDTO>> findMostDiscount(@Param(value = "time_span") String timeSpan);

//    interval :time_span
//    ( :interval )\:\:interval
//    ( :time_span )\:\:interval
//    ( :time_span || ' days')::interval
}