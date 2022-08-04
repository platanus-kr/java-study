package com.example.webapptest3.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/aop")
@RequiredArgsConstructor
public class AopController {

    private final AService aService;
    private final BService bService;

    @GetMapping("/runner")
    @ResponseBody
    public ResponseEntity<?> runner() {
        aService.execute();
        bService.execute();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/status")
    @ResponseBody
    public ResponseEntity<?> status() {
        return ResponseEntity.ok(TestAspect.statusList);
    }
}
