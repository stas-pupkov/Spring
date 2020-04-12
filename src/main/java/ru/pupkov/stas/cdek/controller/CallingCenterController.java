package ru.pupkov.stas.cdek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ru.pupkov.stas.cdek.domain.FilterByDateStart;
import ru.pupkov.stas.cdek.domain.FilterByDateFinish;
import ru.pupkov.stas.cdek.domain.FilterByOrderId;
import ru.pupkov.stas.cdek.domain.TaskForCalling;
import ru.pupkov.stas.cdek.repository.TasksRepository;

import java.sql.Date;

@RestController
public class CallingCenterController {

    @Autowired
    private TasksRepository tasksRepository;

    /** Добавление нового задания для call-центра */
    @PostMapping("/tasks")
    public void addTask(@RequestBody TaskForCalling taskForCalling) {
        tasksRepository.save(taskForCalling);
    }

    /** Получить список заданий */
    @GetMapping("/tasks")
    public Iterable<TaskForCalling> findTasks(@RequestParam(name = "dateStart", required = false) Date dateStart,
                                              @RequestParam(name = "dateFinish", required = false) Date dateFinish,
                                              @RequestParam(name = "orderId", required = false) Integer orderId) {
        if (orderId == null && (dateStart == null || dateFinish == null)) {
            return tasksRepository.findAll();
        }
        else if (orderId == null && dateStart != null && dateFinish != null) {
            return tasksRepository.findAll(Specification
                    .where(FilterByDateStart.filterByDateStart(dateStart)
                    .and(FilterByDateFinish.filterByDateFinish(dateFinish))));
        } else {
            return tasksRepository.findAll(Specification
                    .where(FilterByDateStart.filterByDateStart(dateStart)
                    .and(FilterByDateFinish.filterByDateFinish(dateFinish)))
                    .and(FilterByOrderId.filterByOrderId(orderId)));
        }
    }
}
