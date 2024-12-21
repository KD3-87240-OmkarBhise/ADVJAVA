package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.PlayerDao;
import com.sunbeam.dao.PlayerDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

public class RemovePlayerFromTeam {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in) ){
			PlayerDao playerDao = new PlayerDaoImpl();
			
			System.out.println("Enter Team id to delete player from: ");
			Long teamId = sc.nextLong();
			
			System.out.println("Enter Player id to delete: ");
			Long playerId = sc.nextLong();
			
			System.out.println(playerDao.deletePlayerFromTeam(teamId, playerId));
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
