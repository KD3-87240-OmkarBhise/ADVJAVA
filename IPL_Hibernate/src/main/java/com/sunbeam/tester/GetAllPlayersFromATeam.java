package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Team;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

public class GetAllPlayersFromATeam {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			TeamDao teamDao = new TeamDaoImpl();
			
			System.out.println("Enter the team id to get the players: ");
			Long teamId = sc.nextLong();
			
			Team team = teamDao.getTeamById(teamId);
			System.out.println(team);
				
			System.out.println("All Players");
			team.getPlayers().forEach(System.out::println);;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
