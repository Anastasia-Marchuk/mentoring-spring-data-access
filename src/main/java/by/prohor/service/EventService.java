package by.prohor.service;

import by.prohor.model.Event;

import java.util.Date;
import java.util.List;

/**
 * Created by Artsiom Prokharau 08.07.2021
 */


public interface EventService {

    /**
     * Gets event by its id.
     *
     * @return Event.
     */
    Event getEventById(long eventId);

    /**
     * Get list of events by matching title. Title is matched using 'contains' approach.
     * In case nothing was found, empty list is returned.
     *
     * @param title    Event title or it's part.
     * @param pageSize Pagination param. Number of events to return on a page.
     * @param pageNum  Pagination param. Number of the page to return. Starts from 1.
     * @return List of events.
     */
    List<Event> getEventsByTitle(String title, int pageSize, int pageNum);

    /**
     * Get list of events for specified day.
     * In case nothing was found, empty list is returned.
     *
     * @param day      Date object from which day information is extracted.
     * @param pageSize Pagination param. Number of events to return on a page.
     * @param pageNum  Pagination param. Number of the page to return. Starts from 1.
     * @return List of events.
     */
    List<Event> getEventsForDay(Date day, int pageSize, int pageNum);

    /**
     * Creates new event. Event id should be auto-generated.
     *
     * @param event Event data.
     * @return Created Event object.
     */
    Event createEvent(Event event);

    /**
     * Updates event using given data.
     *
     * @param event Event data for update. Should have id set.
     * @return Updated Event object.
     */
    Event updateEvent(Event event);

    /**
     * Deletes event by its id.
     *
     * @param eventId Event id.
     */
    void deleteEvent(long eventId);

}
