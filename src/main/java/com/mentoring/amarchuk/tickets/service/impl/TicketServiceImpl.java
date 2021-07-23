package com.mentoring.amarchuk.tickets.service.impl;


import com.mentoring.amarchuk.tickets.model.Category;
import com.mentoring.amarchuk.tickets.model.Event;
import com.mentoring.amarchuk.tickets.model.Ticket;
import com.mentoring.amarchuk.tickets.model.User;
import com.mentoring.amarchuk.tickets.service.TicketService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



@Service
@Transactional(readOnly = true)
public class TicketServiceImpl implements TicketService {

    @Override
    public Ticket bookTicket(long userId, long eventId, int place, Category category) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(User user, int pageSize, int pageNum) {
        return null;
    }

    @Override
    public List<Ticket> getBookedTickets(Event event, int pageSize, int pageNum) {
        return null;
    }

    @Override
    @Transactional
    public boolean cancelTicket(long ticketId) {
        return false;
    }
}
