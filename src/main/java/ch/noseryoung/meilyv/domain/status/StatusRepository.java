package ch.noseryoung.meilyv.domain.status;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends ExtendedRepository<Status> {
    Optional<Status> findByName(String name);
}