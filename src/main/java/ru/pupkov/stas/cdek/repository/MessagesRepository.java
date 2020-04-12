package ru.pupkov.stas.cdek.repository;


import org.springframework.data.repository.CrudRepository;
import ru.pupkov.stas.cdek.domain.MessageFromCourier;

import java.util.List;

public interface MessagesRepository extends CrudRepository<MessageFromCourier, Integer> {
    List<MessageFromCourier> findById(String id);
}
