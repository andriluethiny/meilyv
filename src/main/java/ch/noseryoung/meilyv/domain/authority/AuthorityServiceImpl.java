package ch.noseryoung.meilyv.domain.authority;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorityServiceImpl extends ExtendedServiceImpl<Authority> implements AuthorityService {
    @Autowired
    public AuthorityServiceImpl(ExtendedRepository<Authority> repository, Logger logger) {
        super(repository, logger);
    }
}