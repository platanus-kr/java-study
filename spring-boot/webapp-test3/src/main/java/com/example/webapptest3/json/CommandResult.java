package com.example.webapptest3.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommandResult {
    private String cmd;
    @JsonProperty("err_reason")
    private String errReason;
    @JsonProperty("err_code")
    private String errCode;
    private String error;
    private String sequence;
    private String sourceDetails;
}
