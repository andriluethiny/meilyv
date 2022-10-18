package ch.noseryoung.meilyv.core.generic;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

public interface ExtendedService<T extends ExtendedEntity> {
    List<T> findAll();

    List<T> findAll(Pageable pageable);

    T findById(UUID id);

    boolean existsById(UUID id);

    List<T> saveAll(Iterable<T> entities);

    T save(T entity);

    T updateById(UUID id, T entity) throws NoSuchElementException;

    Void deleteById(UUID id) throws NoSuchElementException;

    T findOrThrow(Optional<T> optional) throws NoSuchElementException;
}