package ch.noseryoung.meilyv.domain.teatype;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeaTypeServiceImpl extends ExtendedServiceImpl<TeaType> implements TeaTypeService {
    @Autowired
    public TeaTypeServiceImpl(ExtendedRepository<TeaType> repository, Logger logger) {
        super(repository, logger);
    }
}