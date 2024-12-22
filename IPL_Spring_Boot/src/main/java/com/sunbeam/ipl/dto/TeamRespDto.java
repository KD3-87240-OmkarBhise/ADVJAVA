package com.sunbeam.ipl.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)
public class TeamRespDto extends BaseDto {
	private String name;
	
	private String abbreviation;
	
	
	private String owner;


	private Integer maxPlayerAge;
	
	
	private Double battingAvg;
	
	private Integer wicketsTaken;
}
