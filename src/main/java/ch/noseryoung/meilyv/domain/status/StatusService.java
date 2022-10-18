package ch.noseryoung.meilyv.domain.status;

import ch.noseryoung.meilyv.core.generic.ExtendedService;

public interface StatusService extends ExtendedService<Status> {
    Status findByName(String name);
}