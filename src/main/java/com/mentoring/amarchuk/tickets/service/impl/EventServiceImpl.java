package com.mentoring.amarchuk.tickets.service.impl;


import com.mentoring.amarchuk.tickets.dao.EventDao;
import com.mentoring.amarchuk.tickets.model.Event;
import com.mentoring.amarchuk.tickets.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;



@Service
@Transactional(readOnly = true)
public class EventServiceImpl implements EventService {

    private final EventDao eventDao;

    @Autowired
    public EventServiceImpl(EventDao eventDao) {
        this.eventDao = eventDao;
    }

    @Override
    public Event getEventById(long eventId) {
        return eventDao.findById(eventId).get();
    }

    @Override
    public List<Event> getEventsByTitle(String title, int pageSize, int pageNum) {
        return eventDao.findEventByTitle(title);
    }

    @Override
    public List<Event> getEventsForDay(Date day, int pageSize, int pageNum) {
        return eventDao.findEventByDate(day);
    }

    @Override
    @Transactional
    public Event createEvent(Event event) {
        return eventDao.save(event);
    }

    @Override
    @Transactional
    public Event updateEvent(Event event) {
        return null;
    }

    @Override
    @Transactional
    public void deleteEvent(long eventId) {
        eventDao.deleteById(eventId);
    }
}
