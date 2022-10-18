package ch.noseryoung.meilyv.domain.ordertea;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderTeaServiceImpl extends ExtendedServiceImpl<OrderTea> implements OrderTeaService {
    @Autowired
    public OrderTeaServiceImpl(ExtendedRepository<OrderTea> repository, Logger logger) {
        super(repository, logger);
    }
}