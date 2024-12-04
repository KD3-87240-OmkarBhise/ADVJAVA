package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/vote")
public class VoteServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String candId = req.getParameter("candidate");
		int id = Integer.parseInt(candId);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		out.println("<body>");
		Cookie arr[] = req.getCookies();
		String usrName = "", role = "";
		if(arr != null) {
			for(Cookie c: arr) {
				if(c.getName().equals("uname"))
					usrName = c.getValue();
				if(c.getName().equals("role"))
					role = c.getValue();
			}
		}
		out.printf("Hello, %s (%s) <hr/>\n", usrName, role);
		out.println("<h2>Voting Status</h2>");
		out.println("<form method='post' action='vote'>");
		
		try(CandidateDao candDao = new CandidateDaoImpl()){
			int count = candDao.incrVote(id);
			if(count == 1) {
				out.println("<h4>You have successfully casted you vote!</h4>");
			}
			else {
				out.println("<h4>Your voting failed</h4>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		
		out.println("<p><a href='logout'>Sign Out</a></p>");	
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
	}
}