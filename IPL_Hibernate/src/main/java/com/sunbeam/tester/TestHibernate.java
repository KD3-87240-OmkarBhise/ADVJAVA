package com.sunbeam.tester;

import static com.sunbeam.utils.HibernateUtils.*;
import org.hibernate.*;

public class TestHibernate {
	public static void main(String[] args) {
		try(SessionFactory sf = getSessionFactory()){
			System.out.println("Hibernate Up and Running....");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
