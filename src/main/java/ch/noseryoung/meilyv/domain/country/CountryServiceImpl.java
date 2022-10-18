package ch.noseryoung.meilyv.domain.country;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl extends ExtendedServiceImpl<Country> implements CountryService {
    @Autowired
    public CountryServiceImpl(ExtendedRepository<Country> repository, Logger logger) {
        super(repository, logger);
    }
}