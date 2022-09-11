package by.spring.learn.exception;

/**
 * @Author Vladimir Dolgiy
 * @Version 1.1
 **/
public class MeasurementException extends RuntimeException{
    public MeasurementException(String msg) {
        super(msg);
    }
}
