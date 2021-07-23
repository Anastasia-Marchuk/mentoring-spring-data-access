package com.mentoring.amarchuk.tickets.web.handler;

public class NegativeNumberException extends IllegalArgumentException {
    public NegativeNumberException(String message){ // you can pass in your own message
        super(message);
    }

}