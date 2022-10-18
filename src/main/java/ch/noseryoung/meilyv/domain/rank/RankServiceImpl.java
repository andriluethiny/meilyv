package ch.noseryoung.meilyv.domain.rank;

import ch.noseryoung.meilyv.core.generic.ExtendedRepository;
import ch.noseryoung.meilyv.core.generic.ExtendedServiceImpl;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RankServiceImpl extends ExtendedServiceImpl<Rank> implements RankService {
    @Autowired
    public RankServiceImpl(ExtendedRepository<Rank> repository, Logger logger) {
        super(repository, logger);
    }

    @Override
    public Rank findByName(String name) {
        return findOrThrow(((RankRepository) super.getRepository()).findByName(name));
    }

    @Override
    public Rank findRankBySeeds(Integer seeds) {
        return ((RankRepository) super.getRepository()).findRankBySeeds(seeds);
    }
}