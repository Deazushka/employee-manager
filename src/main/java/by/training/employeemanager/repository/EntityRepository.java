package by.training.employeemanager.repository;

import by.training.employeemanager.entity.AbstractEntity;
import org.springframework.data.repository.CrudRepository;

public interface EntityRepository<T extends AbstractEntity> extends CrudRepository<T, Long> { }
