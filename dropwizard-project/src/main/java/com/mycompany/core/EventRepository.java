package com.mycompany.core;

import java.util.List;

import com.mycompany.api.Event;

public interface EventRepository {
    List<Event> findAll();

}
