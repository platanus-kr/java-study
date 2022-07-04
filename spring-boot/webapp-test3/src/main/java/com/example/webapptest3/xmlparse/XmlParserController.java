package com.example.webapptest3.xmlparse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.file.Files;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping(("/xml"))
public class XmlParserController {
    public static final String XML_PARSE1 = "xmlparse1.xml";

    @Autowired private XmlParserService xmlParserService;

    @GetMapping("/parse1")
    @ResponseBody
    public ResponseEntity parser1() throws IOException {
        String originXml = null;
        try {
            File file = ResourceUtils.getFile("classpath:" + XML_PARSE1);
            originXml = new String(Files.readAllBytes(file.toPath()));
//            InputStream is = new FileInputStream(file);
//            InputStreamReader isr = new InputStreamReader(is);
//            BufferedReader br = new BufferedReader(isr);
//            originXml = br.lines().collect(Collectors.joining(""));
            
        } catch (IOException e){
            log.info(e.getMessage());
        }
        
//        log.info(originXml);
        Document doc = null;
        try {
            xmlParserService.parse(originXml);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }


        return ResponseEntity.ok("200");

    }
}
