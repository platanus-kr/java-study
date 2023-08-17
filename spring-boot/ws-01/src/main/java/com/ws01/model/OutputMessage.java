package com.ws01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OutputMessage extends Message {
	private String time;

	public OutputMessage(String from, String text, String time) {
		super(from, text);
		this.time = time;
	}
}
