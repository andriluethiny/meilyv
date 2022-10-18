package ch.noseryoung.meilyv.domain.role;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends ExtendedRepository<Role> {
    Optional<Role> findByName(String name);
}