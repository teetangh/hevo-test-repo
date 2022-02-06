package com.mycompany.core;

import java.util.List;
import java.util.Optional;

import com.mycompany.api.Event;

public interface EventRepository {
    List<Event> findAll();

    Optional<Event> findById(Long id);

    Event save(Event event);

    Optional<Event> update(Long id, Event event);

    void delete(Long id);

}
