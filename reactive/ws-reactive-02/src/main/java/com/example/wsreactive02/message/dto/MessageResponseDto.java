package com.example.wsreactive02.message.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponseDto {

    private String command;
    private String message;
    private String timestamp;
    private IdentifierDto identifier;

}
