package com.example.wsreactive02.message.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageRequestDto {

    private String command;
    private String message;
    private LocalDateTime sendTime;
    private IdentifierDto identifier;

}
