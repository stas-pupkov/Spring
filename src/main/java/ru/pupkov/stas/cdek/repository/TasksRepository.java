package ru.pupkov.stas.cdek.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import ru.pupkov.stas.cdek.domain.TaskForCalling;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<TaskForCalling, Integer>, JpaSpecificationExecutor<TaskForCalling> {
    List<TaskForCalling> findByOrderId(String id);

}
