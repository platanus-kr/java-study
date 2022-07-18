package com.example.webapptest3.multipart;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;

@Slf4j
@Controller
@RequestMapping("/servlet/v1")
public class ServletMultipartControllerV1 {

    @GetMapping("/upload")
    public String newFile() {
        return "upload-form";
    }

    @PostMapping("/upload")
    public String saveFileV1(HttpServletRequest request) throws ServletException, IOException {
        log.info("request={}", request);

        String itemName = request.getParameter("itemName");
        log.info("itemName={}", itemName);

        String priceName = request.getParameter("priceName");
        log.info("itemName={}", priceName);

        String labelName = request.getParameter("labelName");
        log.info("itemName={}", labelName);

        String distributorName = request.getParameter("distributorName");
        log.info("itemName={}", distributorName);

        Collection<Part> parts = request.getParts();
        log.info("parts={}", parts);

        return "upload-form";

    }
}
