package com.mongodb.mongodb.Exceptions;

public class NotEnoughStockException extends RuntimeException{

    public NotEnoughStockException(String message) {
        super(message);
    }
}
