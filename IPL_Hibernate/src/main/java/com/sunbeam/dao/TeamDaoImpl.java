package com.sunbeam.dao;

import org.hibernate.*;

import com.sunbeam.entities.Team;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;

import java.io.Serializable;
import java.util.List;

public class TeamDaoImpl implements TeamDao {

	@Override
	public String registerNewTeam(Team team) {
		String msg = "Team Regisration Failed!!!!!";
		//1.get session from session factory
		Session session = getSessionFactory().getCurrentSession();
		
		//2.begin a transaction
		Transaction tx = session.beginTransaction();
		
		try {
			Serializable teamId = session.save(team);
			tx.commit();
			msg = "New Team Registered! ID: " + teamId;
		}catch (Exception e) {
			
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		return msg;
	}

	@Override
	public List<Team> getAllTeams() {
		String jpql = "select t from Team t";
		
		List<Team> teams = null;
		
		//1.get session from session factory
		Session session = getSessionFactory().getCurrentSession();
		
		//2.begin a transaction
		Transaction tx = session.beginTransaction();
		
		try {
			teams = session.createQuery(jpql, Team.class).getResultList();
			tx.commit();
		}catch (Exception e) {
			
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		return teams;
	}

	@Override
	public List<Team> getAllTeamsWithAgeAndAvgCriteria(Integer age, Double avg) {
		String jpql = "select t from Team t where t.maxPlayerAge <:age and t.battingAvg >:avg";
		
		List<Team> teams = null;
		
		//1.get session from session factory
		Session session = getSessionFactory().getCurrentSession();
		
		//2.begin a transaction
		Transaction tx = session.beginTransaction();
		
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("age", age).setParameter("avg", avg).getResultList();
			tx.commit();
		}catch (Exception e) {
			
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		return teams;
	}

	@Override
	public List<Team> GetOwnNAbrevWithAgeNAvgCriteria(Integer age, Double avg) {
		String jpql = "select new com.sunbeam.entities.Team(abbreviation, owner) from Team t where t.maxPlayerAge <:age and t.battingAvg >:avg";
		
		List<Team> teams = null;
		
		//1.get session from session factory
		Session session = getSessionFactory().getCurrentSession();
		
		//2.begin a transaction
		Transaction tx = session.beginTransaction();
		
		try {
			teams = session.createQuery(jpql, Team.class).setParameter("age", age).setParameter("avg", avg).getResultList();
			tx.commit();
		}catch (Exception e) {
			
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		return teams;
	}

	@Override
	public String updateMaxAge(String teamName, int newAge) {
		String msg = "Max Age Updation Failed!!!!!";
		String jpql = "select t from Team t where t.name =:tm";
		Team team =null;
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			team = session.createQuery(jpql, Team.class).setParameter("tm", teamName).getSingleResult();
			
			team.setMaxPlayerAge(newAge);
			
			tx.commit();
			
			msg = "Max Age Updation Successfull!!!";
			
			
		}catch (RuntimeException e) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		
		return msg;
	}

	@Override
	public String deleteById(Long teamID) {
		String msg = "Team Deletion Failed!!!!";
		Team team = null;
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			team = session.get(Team.class, teamID);
			if(team != null) {
				session.delete(team);
				msg = "Team Deletion Successfull!!!!!";
			}
			tx.commit();
			
		} catch (RuntimeException e) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		
		return msg;
	}

	@Override
	public Team getTeamById(Long teamId) {
		Team team = null;
		String jpql = "Select t from Team t left join fetch t.players where t.id = :id";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			team = session.createQuery(jpql, Team.class).setParameter("id", teamId).getSingleResult();
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx !=null) {
				tx.rollback();
			}
			throw e;
		}
		
		return team;
	}

	
}
