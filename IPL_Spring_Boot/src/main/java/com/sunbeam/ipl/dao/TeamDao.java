package com.sunbeam.ipl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sunbeam.ipl.pojos.Team;

public interface TeamDao extends JpaRepository<Team, Long>{

}
