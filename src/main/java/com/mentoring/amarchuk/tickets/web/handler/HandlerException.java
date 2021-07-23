package com.mentoring.amarchuk.tickets.web.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Artsiom Prokharau 12.07.2021
 */

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public String exIndexOfBounds(Model model, IndexOutOfBoundsException ex) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
    @ExceptionHandler(IllegalStateException.class)
    public String illigaleName(Model model, IllegalStateException ex) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }

    @ExceptionHandler(NegativeNumberException.class)
    public String notEnoughMoney(Model model, IllegalStateException ex) {
        model.addAttribute("message", ex.getMessage());
        return "error";
    }
}
