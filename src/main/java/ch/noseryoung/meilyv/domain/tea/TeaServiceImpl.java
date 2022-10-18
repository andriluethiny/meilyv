package ch.noseryoung.meilyv.domain.tea;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaServiceImpl extends ExtendedServiceImpl<Tea> implements TeaService {
    @Autowired
    public TeaServiceImpl(ExtendedRepository<Tea> repository, Logger logger) {
        super(repository, logger);
    }
}