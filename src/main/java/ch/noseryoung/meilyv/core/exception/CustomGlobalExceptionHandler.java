package ch.noseryoung.meilyv.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomGlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseError handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        return new ResponseError()
                .setTimeStamp(LocalDate.now())
                .setErrors(ex.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(error -> error.getField(), error -> error.getDefaultMessage())))
                .build();
    }

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseError handleNoSuchElementException(NoSuchElementException ex, HttpServletRequest request) {
        return new ResponseError()
                .setTimeStamp(LocalDate.now())
                .setErrors(new HashMap<>(Map.of("error", ex.getMessage())))
                .build();
    }

    @ExceptionHandler(IllegalActionException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ResponseError handleIllegalActionException(IllegalActionException ex, HttpServletRequest request) {
        return new ResponseError()
                .setTimeStamp(LocalDate.now())
                .setErrors(new HashMap<>(Map.of("error", ex.getMessage())))
                .build();
    }
}