package ru.pupkov.stas.cdek.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pupkov.stas.cdek.domain.MessageFromCourier;
import ru.pupkov.stas.cdek.repository.MessagesRepository;

@RestController
public class CourierController {

    @Autowired
    private MessagesRepository messagesRepository;

    @GetMapping("/messages")
    public Iterable<MessageFromCourier> getMessages() {
        return messagesRepository.findAll();
    }

    @PostMapping("/messages")
    public Iterable<MessageFromCourier> addMessage(@RequestBody MessageFromCourier messageFromCourier) {
        messagesRepository.save(messageFromCourier);
        return messagesRepository.findAll();
    }

    @DeleteMapping("/messages/{id}")
    public Iterable<MessageFromCourier> deleteMessage(@PathVariable("id") int id) {
        messagesRepository.deleteById(id);
        return messagesRepository.findAll();
    }
}
