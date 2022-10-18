package ch.noseryoung.meilyv.domain.status;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl extends ExtendedServiceImpl<Status> implements StatusService {
    @Autowired
    public StatusServiceImpl(ExtendedRepository<Status> repository, Logger logger) {
        super(repository, logger);
    }

    @Override
    public Status findByName(String name) {
        return findOrThrow(((StatusRepository) super.getRepository()).findByName(name));
    }
}