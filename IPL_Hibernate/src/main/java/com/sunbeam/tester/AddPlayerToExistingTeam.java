package com.sunbeam.tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;
import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Player;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;


public class AddPlayerToExistingTeam {

	public static void main(String[] args) {
		try(SessionFactory sf= getSessionFactory(); Scanner sc = new Scanner(System.in)) {
			TeamDao teamDao = new TeamDaoImpl();
			teamDao.getAllTeams().forEach(System.out::println);
			
			PlayerDao playerDao = new PlayerDaoImpl();
			
			System.out.println("Enter team id: ");
			Long teamId = sc.nextLong();
			
			System.out.println("Enter first Name: ");
			String firstName = sc.next();
			
			System.out.println("Enter last Name: ");
			String LastName = sc.next();
			
			System.out.println("Enter the Date of Birth: ");
			LocalDate dob = LocalDate.parse(sc.next());
			
			System.out.println("Enter Batting avg: ");
			Double bAvg = sc.nextDouble();
			
			System.out.println("Enter Wickets Taken: ");
			Integer wt = sc.nextInt();
			
			Player player = new Player(firstName, LastName, dob, bAvg, wt);
			
			System.out.println(playerDao.newPlayer(teamId, player));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
