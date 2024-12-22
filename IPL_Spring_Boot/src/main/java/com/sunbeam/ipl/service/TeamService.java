package com.sunbeam.ipl.service;

import java.util.List;

import com.sunbeam.ipl.dto.ApiResponse;
import com.sunbeam.ipl.dto.TeamReqDto;
import com.sunbeam.ipl.dto.TeamRespDto;

public interface TeamService {
	List<TeamRespDto> getAllTeams();
	
	ApiResponse addNewTeam(TeamReqDto teamDto);
}
