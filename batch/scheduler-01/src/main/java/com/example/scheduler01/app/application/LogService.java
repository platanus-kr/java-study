package com.example.scheduler01.app.application;

import com.example.scheduler01.app.application.dto.LogRequest;
import com.example.scheduler01.app.application.dto.LogResponse;
import com.example.scheduler01.app.domain.Log;
import com.example.scheduler01.app.domain.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogRepository logRepository;

    public List<LogResponse> findAll() {
        List<Log> logs = logRepository.findAll();
        return LogResponse.from(logs);
    }

    public void append(LogRequest request) {
        Log log = LogRequest.to(request);
        logRepository.save(log);
    }
}
