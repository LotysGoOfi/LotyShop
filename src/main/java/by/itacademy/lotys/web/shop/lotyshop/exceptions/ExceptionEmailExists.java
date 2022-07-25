package by.itacademy.lotys.web.shop.lotyshop.exceptions;

public class ExceptionEmailExists extends RuntimeException{
    public ExceptionEmailExists(String message) {
        super(message+"email exist");
    }
}
