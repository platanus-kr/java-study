package com.ws01.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	private String from;
	private String text;

	@Override
	public String toString() {
		return "Message{" +
				"from='" + from + '\'' +
				", text='" + text + '\'' +
				'}';
	}
}
