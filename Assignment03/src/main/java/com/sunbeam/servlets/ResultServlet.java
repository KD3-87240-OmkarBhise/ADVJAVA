package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.CandidateDao;
import com.sunbeam.daos.CandidateDaoImpl;
import com.sunbeam.entities.Candidate;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processRequest(req, resp);
	}
	
	protected void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Candidate> list = new ArrayList<Candidate>();
		try(CandidateDao candDao = new CandidateDaoImpl()){
			list = candDao.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Candidate List</title>");
		out.println("</head>");
		ServletContext col = req.getServletContext();
		String bgCol = col.getInitParameter("bg.color");
		out.printf("<body style='%s'>", bgCol);
		
		ServletContext app = req.getServletContext();
		String appTitle = app.getInitParameter("app.title");
		out.printf("<h1>%s</h1>", appTitle);
		
		HttpSession session = req.getSession(false);
		if(session == null) {
			resp.sendError(440);
			return;
		}
		
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
		
		ServletContext ctx = this.getServletContext();
		String ann = (String) ctx.getAttribute("annoucement");
		if(ann != null) {
			out.println("<p style='color:red'> Note: " + ann + "</p>");
		}
		
		out.println("<h2>Voting Result</h2>");
		
		out.println("<table border=1>");
		out.println("<thead>");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>Name</th>");
		out.println("<th>Party</th>");
		out.println("<th>Votes</th>");
		out.println("<th>Action</th>");
		out.println("</tr>");
		out.println("</thead>");
		out.println("<tbody>");
		for(Candidate c: list) {
			out.println("<tr>");
			out.printf("<td>%d</td>\n", c.getId());
			out.printf("<td>%s</td>\n", c.getName());
			out.printf("<td>%s</td>\n", c.getParty());
			out.printf("<td>%d</td>\n", c.getVotes());
			out.printf("<td>\n");
			out.printf("<a href='editcand?id=%d'>Edit</a>\n", c.getId());
			out.printf("<a href='delcand?id=%d'>Delete</a>\n", c.getId());
//			out.printf("<a href='editcand?id=%d'><image src='image/edit.png' alt='Edit' width='24' height='24'/></a>\n", c.getId());
//			out.printf("<a href='delcand?id=%d'><image src='image/edit.png' alt='Edit' width='24' height='24'/></a>\n", c.getId());
			out.printf("</td>\n");
			out.println("</tr>");
		}
		out.println("</tbody>");
		out.println("</table>");
		String message = (String) req.getAttribute("msg");
		if(message != null) {
			out.println("<p>"+ message +"</p>");
		}
		
		out.println("<p> <a href='announcement.html'>Announcement</a> | <a href='index.html'>Login Again</a></p><br><br>");
		out.println("<p><a href='newcandidate.html'>Add New Candidate</a></p>");	
		out.println("</body>");
		out.println("</html>");
	}
}