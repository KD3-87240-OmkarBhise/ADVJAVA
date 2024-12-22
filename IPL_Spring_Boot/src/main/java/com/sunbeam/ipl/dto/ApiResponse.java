package com.sunbeam.ipl.dto;

import java.time.LocalDateTime;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class ApiResponse {
	private String message;
	private LocalDateTime timeStramp;
	public ApiResponse(String message) {
		super();
		this.message = message;
		this.timeStramp = LocalDateTime.now();
	}
	
}
