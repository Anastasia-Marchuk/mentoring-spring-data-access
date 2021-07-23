package com.mentoring.amarchuk.tickets.dao.impl;

import com.mentoring.amarchuk.tickets.dao.EventDao;
import com.mentoring.amarchuk.tickets.model.Event;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"classpath:config.xml"})
@Transactional
class EventDaoTest {

    @Autowired
    private EventDao eventDao;

    @Test
    void getEventById() {
        Event event = new Event("Test", new Date("12/12/2012"));
        eventDao.save(event);
        assertEquals(event, eventDao.findById(event.getId()).get());
    }

    @Test
    void getEventsByTitle() {
        Event event1 = new Event("Test", new Date("12/12/2012"));
        Event event2 = new Event("Test", new Date("12/12/2012"));
        eventDao.save(event1);
        eventDao.save(event2);
        assertEquals(2, eventDao.findEventByTitle("Test").size());
    }

    @Test
    void getEventsByTitleReturnEmptyList() {
        assertTrue(eventDao.findEventByTitle("Test").isEmpty());
    }

    @Test
    void getEventsForDay() {
        Event event = new Event("Test", new Date("12/12/2012"));
        eventDao.save(event);
        Date date = new Date("12/12/2012");
        assertEquals(1, eventDao.findEventByDate(date).size());
    }

    @Test
    void createEvent() {
        Event event = new Event("Test", new Date("12/12/2012"));
        assertEquals(0, eventDao.findAll().size());
        eventDao.save(event);
        assertEquals(1, eventDao.findAll().size());
    }

    @Test
    void updateEvent() {
        Event event = new Event("Test", new Date("12/12/2012"));
    }

//    @Test
//    void deleteEvent() {
//        Event event = new Event("Test", new Date("12/12/2012"));
//        eventDao.save(event);
//        assertEquals(event, eventDao.findById(event.getId()).get());
//        eventDao.deleteById(event.getId());
//        Assertions.assertTrue(eventDao.findById(event.getId()).isEmpty());
//    }
}