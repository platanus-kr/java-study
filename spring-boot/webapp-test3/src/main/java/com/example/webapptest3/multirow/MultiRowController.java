package com.example.webapptest3.multirow;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequestMapping("/multirow")
public class MultiRowController {

    @GetMapping ("/set")
    @ResponseBody
    public String setMultiRow(@ModelAttribute MultiRow mr){
        log.info("for debugger");
        log.info(mr.toString());
        return "200";
    }
}
