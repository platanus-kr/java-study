package com.example.scheduler01.app.ui;

import com.example.scheduler01.app.application.LogService;
import com.example.scheduler01.app.application.dto.LogRequest;
import com.example.scheduler01.app.application.dto.LogResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/log")
@RequiredArgsConstructor
public class LogController {

    private final LogService logService;

    @GetMapping
    public ResponseEntity<List<LogResponse>> retrieveLogs() {
        var responses = logService.findAll();
        return ResponseEntity.ok(responses);
    }

    @PostMapping
    public ResponseEntity<Void> appendLog(@RequestBody LogRequest request) {
        logService.append(request);
        return ResponseEntity.status(HttpStatus.CREATED.value()).build();
    }
}
