package by.itacademy.lotys.web.shop.lotyshop.exceptions;

public class EmailExistsException extends RuntimeException{
    public EmailExistsException(String message) {
        super(message+"email exist");
    }
}
