package com.sunbeam.ipl.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeamReqDto {
	private String name;
	
	private String abbreviation;
	
	
	private String owner;


	private Integer maxPlayerAge;
	
	
	private Double battingAvg;
	
	private Integer wicketsTaken;
}
