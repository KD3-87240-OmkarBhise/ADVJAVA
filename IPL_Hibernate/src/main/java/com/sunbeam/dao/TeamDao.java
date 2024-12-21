package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Team;

public interface TeamDao {
	String registerNewTeam(Team team);
	List<Team> getAllTeams();
	List<Team> getAllTeamsWithAgeAndAvgCriteria(Integer age, Double avg);
	List<Team> GetOwnNAbrevWithAgeNAvgCriteria(Integer age, Double avg);
	String updateMaxAge(String teamName, int newAge);
	String deleteById(Long teamID);
	Team getTeamById(Long teamId);

	
}
