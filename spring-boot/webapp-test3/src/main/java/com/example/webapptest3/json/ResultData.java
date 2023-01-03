package com.example.webapptest3.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResultData {
    @JsonProperty("result")
    List<CommandResult> crList = new ArrayList<>();
}
