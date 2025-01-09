package org.platanus.webappboard.common;

import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ModelAndView defaultExceptionHandler(HttpServletRequest request, Exception exception) {
        ModelAndView modelAndView = new ModelAndView("/error/defaultError");
        modelAndView.addObject("defaultError", exception);

        log.error("defaultExceptionHandler", exception);

        return modelAndView;
    }
}
