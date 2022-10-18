package ch.noseryoung.meilyv.domain.role;

import ch.noseryoung.meilyv.core.generic.ExtendedService;

public interface RoleService extends ExtendedService<Role> {
    Role findByName(String name);
}