package com.mentoring.amarchuk.tickets.dao;

import com.mentoring.amarchuk.tickets.model.Category;
import com.mentoring.amarchuk.tickets.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;



public interface TicketDao extends JpaRepository<Ticket, Long> {
    /**
     * Book ticket for a specified event on behalf of specified user.
     *
     * @param category Service category.
     * @return Booked ticket object.
     * @throws IllegalStateException if this place has already been booked.
     */
    Ticket findByCategory(Category category);

    /**
     * Get all booked tickets for specified user. Tickets should be sorted by event date in descending order.
     *
     * @return List of Ticket objects.
     */
    List<Ticket> findAllByUserId(Long userId);

    /**
     * Get all booked tickets for specified event. Tickets should be sorted in by user email in ascending order.
     *
     * @return List of Ticket objects.
     */
    List<Ticket> findAllByEventId(Long eventId);

    /**
     * Cancel ticket with a specified id.
     *
     * @param ticketId Ticket id.
     * @return Flag whether anything has been canceled.
     */
    boolean deleteById(long ticketId);

}
