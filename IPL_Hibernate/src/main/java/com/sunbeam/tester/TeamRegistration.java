package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;
import com.sunbeam.entities.Team;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

public class TeamRegistration {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			
			TeamDao teamDao = new TeamDaoImpl();
			
			System.out.println("Enter Team Name: ");
			String name = sc.nextLine();
			sc.nextLine();
			System.out.println("Enter Abbreviation: ");
			String abvn = sc.next();
			System.out.println("Enter Owner: ");
			String own = sc.next();
			System.out.println("Enter max player age: ");
			Integer mpa = sc.nextInt();
			System.out.println("Enter Batting avg: ");
			Double ba = sc.nextDouble();
			System.out.println("Enter Wickets Taken: ");
			Integer wt = sc.nextInt();
			
			Team newTeam = new Team(name, abvn, own, mpa, ba, wt);
			
			System.out.println(teamDao.registerNewTeam(newTeam));
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
