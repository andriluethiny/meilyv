package ch.noseryoung.meilyv.domain.user;

import ch.noseryoung.meilyv.core.generic.ExtendedService;
import ch.noseryoung.meilyv.domain.user.dto.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.UUID;

public interface UserService extends UserDetailsService, ExtendedService<User> {
    User register(User user);

    UserDetailsImpl findPrincipalUser();

    List<UserDTO> findMostDiscount(String timeSpan);

    User lockUser(UUID id);

    User unlockUser(UUID id);
}