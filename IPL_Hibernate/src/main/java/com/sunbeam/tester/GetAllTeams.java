package com.sunbeam.tester;


import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;

public class GetAllTeams {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory() ){
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("All Teams: ");
			teamDao.getAllTeams().forEach(System.out::println);;
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
