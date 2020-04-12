package ru.pupkov.stas.cdek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ru.pupkov.stas.cdek.domain.Filter;
import ru.pupkov.stas.cdek.domain.Filter2;
import ru.pupkov.stas.cdek.domain.Filter3;
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

    @DeleteMapping("/tasks/{id}")
    public Iterable<TaskForCalling> deleteTask(@PathVariable("id") int id) {
        tasksRepository.deleteById(id);
        return tasksRepository.findAll();
    }

    @GetMapping("/tasks")
    public Iterable<TaskForCalling> filterTasks(@RequestParam("dateStart") Date dateStart,
                                                @RequestParam("dateFinish") Date dateFinish,
                                                @RequestParam(name = "orderNumber", required = false) Integer number) {
        if (number == null) {
            return tasksRepository.findAll(Specification.where(Filter.checkCompleted(dateStart)
                    .and(Filter2.checkCompleted(dateFinish))));
        } else {
            return tasksRepository.findAll(Specification.where(Filter.checkCompleted(dateStart)
                    .and(Filter2.checkCompleted(dateFinish))).and(Filter3.checkCompleted(number)));
        }
    }

}
