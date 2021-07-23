package com.mentoring.amarchuk.tickets.dao;

import com.mentoring.amarchuk.tickets.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;



public interface EventDao extends JpaRepository<Event, Long> {

    /**
     * Get list of events for specified day.
     * In case nothing was found, empty list is returned.
     *
     * @param day Date object from which day information is extracted.
     * @return List of events.
     */
    List<Event> findEventByDate(Date day);

    List<Event> findEventByTitle(String title);
}

