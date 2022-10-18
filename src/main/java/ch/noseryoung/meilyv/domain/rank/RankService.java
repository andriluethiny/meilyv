package ch.noseryoung.meilyv.domain.rank;

import ch.noseryoung.meilyv.core.generic.ExtendedService;

public interface RankService extends ExtendedService<Rank> {
    Rank findByName(String name);

    Rank findRankBySeeds(Integer seeds);
}