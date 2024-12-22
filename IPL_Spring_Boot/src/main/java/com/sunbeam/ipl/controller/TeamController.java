package com.sunbeam.ipl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.sunbeam.ipl.dto.TeamReqDto;
import com.sunbeam.ipl.dto.TeamRespDto;
import com.sunbeam.ipl.service.TeamService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/teams")
public class TeamController {
	@Autowired
	private TeamService teamService;
	
	
	
	public TeamController() {
		System.out.println("in ctor: " + getClass());
	}
	
	@GetMapping
	public ResponseEntity<?> getAllTeams(){
		List<TeamRespDto> teams = teamService.getAllTeams();
		
		if(teams.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		
		return ResponseEntity.ok(teams);
	}
	



	@PostMapping
	public ResponseEntity<?> addNewTeam(@RequestBody TeamReqDto teamDto) {
	
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addNewTeam(teamDto));
	}
	

}
