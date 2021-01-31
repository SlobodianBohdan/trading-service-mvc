package com.trading.exception.handler;


import com.trading.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ServiceException.class})
    public String handleServiceException(ServiceException serviceException, Model model) {

        log.error("Service exception occurred!", serviceException);

        model.addAttribute("errorMessage", serviceException.getMessage());

        return "main/error";
    }


    @ExceptionHandler({RuntimeException.class})
    public String handleRuntimeException(RuntimeException runtimeException, Model model) {

        log.error("Service exception occurred!", runtimeException);

        model.addAttribute("errorMessage", "An error has occurred!");

        return "main/error";
    }

}
