package com.sunbeam.Beans;

import java.util.ArrayList;
import java.util.List;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

public class CandidatBean {
	private List<Candidate> candList;
	public CandidatBean() {
		candList = new ArrayList<Candidate>();
	}
	public List<Candidate> getCandList() {
		return candList;
	}
	public void setCandList(List<Candidate> candList) {
		this.candList = candList;
	}
	
	public void fetchCandidates() {
		try(CandidateDao candDao = new CandidateDaoImpl()){
			this.candList = candDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
