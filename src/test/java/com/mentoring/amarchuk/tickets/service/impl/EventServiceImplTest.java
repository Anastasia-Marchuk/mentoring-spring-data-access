package com.mentoring.amarchuk.tickets.service.impl;

import com.mentoring.amarchuk.tickets.dao.EventDao;
import com.mentoring.amarchuk.tickets.model.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EventServiceImplTest {

    @InjectMocks
    EventServiceImpl eventService;

    @Mock
    EventDao eventDao;

    Event event1 = new Event("Mock", new Date("07/07/2021"));
    Event event2 = new Event("Mock", new Date("07/07/2021"));

    @Test
    void getEventById() {

        when(eventDao.findById(any(Long.class))).thenReturn(Optional.of(event1));

        Event eventById = eventService.getEventById(0);
        assertEquals(eventById, event1);
    }

    @Test
    void getEventsByTitle() {

        List<Event> list = Arrays.asList(event1, event2);
        when(eventDao.findEventByTitle(any())).thenReturn(list);
        List<Event> mock = eventService.getEventsByTitle("Mock", 1, 1);
        assertEquals(list.size(), mock.size());
    }

    @Test
    void getEventsForDay() {

        List<Event> list = Arrays.asList(event1, event2);
        when(eventDao.findEventByDate(any())).thenReturn(list);
        List<Event> mock = eventService.getEventsForDay(new Date("07/07/2021"), 1, 1);
        assertEquals(list.size(), mock.size());
    }

    @Test
    void createEvent() {
        when(eventDao.save(any())).thenReturn(event1);
        assertEquals(eventService.createEvent(event1), event1);

    }
}