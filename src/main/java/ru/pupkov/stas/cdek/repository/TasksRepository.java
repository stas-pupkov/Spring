package ru.pupkov.stas.cdek.repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.pupkov.stas.cdek.domain.MessageFromCourier;
import ru.pupkov.stas.cdek.domain.TaskForCalling;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TaskForCalling, Integer>, JpaSpecificationExecutor<TaskForCalling> {
    List<TaskForCalling> findById(String id);

}
