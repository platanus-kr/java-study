package com.example.wsreactive02.message;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MessageDto {

    private String message;
    private LocalDateTime sendTime;
    private String token;
    private IdentifierDto identifier;

}
