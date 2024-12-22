package com.sunbeam.ipl.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sunbeam.ipl.dao.TeamDao;
import com.sunbeam.ipl.dto.ApiResponse;
import com.sunbeam.ipl.dto.TeamReqDto;
import com.sunbeam.ipl.dto.TeamRespDto;
import com.sunbeam.ipl.pojos.Team;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamDao teamDao;
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	
	@Override
	public List<TeamRespDto> getAllTeams() {
		return teamDao.findAll()
				.stream()
				.map(team -> modelMapper.map(team, TeamRespDto.class))
				.collect(Collectors.toList());
	}




	@Override
	public ApiResponse addNewTeam(TeamReqDto teamDto) {
		Team team = modelMapper.map(teamDto, Team.class);
		
		Team persistentTeam = teamDao.save(team);
		
		return new ApiResponse("New Team Registered with Id: " + persistentTeam.getId());
	}

}
