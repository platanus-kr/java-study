package com.webfluxmultipart.ui;

import com.webfluxmultipart.application.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/file")
@RequiredArgsConstructor
public class MultipartController {

    private final FileService fileService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.OK)
    public Flux<String> upload(@RequestPart Flux<FilePart> files) {
        Flux<String> lines = fileService.getLines(files);
        return lines;
    }
}
