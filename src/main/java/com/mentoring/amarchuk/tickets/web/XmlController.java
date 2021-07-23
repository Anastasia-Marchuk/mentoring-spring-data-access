package com.mentoring.amarchuk.tickets.web;

import com.mentoring.amarchuk.tickets.facade.BookingFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Artsiom Prokharau 12.07.2021
 */

@Controller
public class XmlController {

    @Autowired
    BookingFacade bookingFacade;

    @GetMapping("/xml")
    public String getPageXml() {
        bookingFacade.preloadUsers();
        return "redirect:/";
    }
}
