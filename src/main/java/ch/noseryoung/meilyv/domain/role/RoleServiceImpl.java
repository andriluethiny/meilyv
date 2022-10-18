package ch.noseryoung.meilyv.domain.role;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService {
    @Autowired
    public RoleServiceImpl(ExtendedRepository<Role> repository, Logger logger) {
        super(repository, logger);
    }

    @Override
    public Role findByName(String name) {
        return findOrThrow(((RoleRepository) super.getRepository()).findByName(name));
    }
}