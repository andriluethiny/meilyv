package ch.noseryoung.meilyv.domain.user;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import ch.noseryoung.meilyv.domain.rank.RankService;
import ch.noseryoung.meilyv.domain.role.RoleService;
import ch.noseryoung.meilyv.domain.user.dto.UserDTO;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RankService rankService;

    private final RoleService roleService;

    @Autowired
    public UserServiceImpl(ExtendedRepository<User> repository, Logger logger, BCryptPasswordEncoder bCryptPasswordEncoder, RankService rankService, RoleService roleService) {
        super(repository, logger);
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.rankService = rankService;
        this.roleService = roleService;
    }

    @Override
    public User register(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setAge(0);
        user.setSeeds(0);
        user.setRank(rankService.findByName("BRONZE"));
        user.setRoles(new HashSet<>(Arrays.asList(roleService.findByName("ROLE_USER"), roleService.findByName("ROLE_STATS"), roleService.findByName("ROLE_DEV"), roleService.findByName("ROLE_ADMIN"))));
        return save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return ((UserRepository) super.getRepository()).findByEmail(email).map(UserDetailsImpl::new).orElseThrow(() -> new UsernameNotFoundException(email));
    }

    @Override
    public UserDetailsImpl findPrincipalUser() {
        return ((UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }

    @Override
    public User lockUser(UUID id) {
        if (existsById(id)) {
            User user = findById(id);
            if (!(findPrincipalUser().hasAnyRole(new HashSet<>(Set.of("ROLE_ADMIN"))))) {
                user.setNonLocked(false);
            }
            return save(user);
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

    @Override
    public User unlockUser(UUID id) {
        if (existsById(id)) {
            User user = findById(id);
            if (!(findPrincipalUser().hasAnyRole(new HashSet<>(Set.of("ROLE_ADMIN"))))) {
                user.setNonLocked(true);
            }
            return save(user);
        } else {
            throw new NoSuchElementException(String.format("Entity with ID '%s' could not be found", id));
        }
    }

    public List<UserDTO> findMostDiscount(String timeSpan) {
        Optional<List<UserDTO>> optional = ((UserRepository) super.getRepository()).findMostDiscount(timeSpan);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }
}