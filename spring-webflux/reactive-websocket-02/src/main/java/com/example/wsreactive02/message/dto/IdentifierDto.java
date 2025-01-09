package com.example.wsreactive02.message.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IdentifierDto {
    private String channel;
    private String nickname;
    private String token;

}
