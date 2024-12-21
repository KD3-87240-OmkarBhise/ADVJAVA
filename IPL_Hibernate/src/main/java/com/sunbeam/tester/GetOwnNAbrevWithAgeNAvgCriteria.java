package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.sunbeam.dao.TeamDao;
import com.sunbeam.dao.TeamDaoImpl;

public class GetOwnNAbrevWithAgeNAvgCriteria {

	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory(); Scanner sc = new Scanner(System.in)){
			TeamDao teamDao = new TeamDaoImpl();
			System.out.println("Enter Age: ");
			Integer age = sc.nextInt();
			System.out.println("Enter Average:");
			Double avg = sc.nextDouble();
			
			//teamDao.GetOwnNAbrevWithAgeNAvgCriteria(age, avg).forEach(System.out::println);
			teamDao.GetOwnNAbrevWithAgeNAvgCriteria(age, avg).forEach(team -> System.out.println(team.getAbbreviation() + " " + team.getOwner()));
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
