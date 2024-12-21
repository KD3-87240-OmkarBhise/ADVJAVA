package com.sunbeam.tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

public class DeleteTeamById {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter Team Id to Delete: ");
			String msg = teamDao.deleteById(sc.nextLong());
			System.out.println(msg);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
