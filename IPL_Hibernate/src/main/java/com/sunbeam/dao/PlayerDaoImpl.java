package com.sunbeam.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.sunbeam.entities.Player;
import com.sunbeam.entities.Team;

import static com.sunbeam.utils.HibernateUtils.getSessionFactory;


public class PlayerDaoImpl implements PlayerDao {

	@Override
	public String newPlayer(Long teamId, Player player) {
		String msg = "Player registration Failed!!!";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			Team team = session.get(Team.class, teamId);
			
			if(team != null) {
				team.addPlayer(player);
				msg = "Player registration successfull!!!";
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
	public String deletePlayerFromTeam(Long teamId, Long playerId) {
		String msg = "Player Deletion from team failed!!!!";
		
		Session session = getSessionFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			Player player = session.get(Player.class, playerId);
			
			Team team = session.get(Team.class, teamId);
			
			if(team != null && player != null) {
				team.removePlayer(player);
				msg = "Player Deleted Successfully!!!!";
			}
			
			tx.commit();
			
			
		}catch (RuntimeException e) {
			// TODO: handle exception
			if(tx != null)
				tx.rollback();
			
			throw e;
		}
		
		return msg;
	}

}
