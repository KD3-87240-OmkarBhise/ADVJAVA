<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Edit Candidate</h1>
	<jsp:useBean id="fcb" class="com.sunbeam.Beans.FindCandBean"/>
	<jsp:setProperty property="candId" name="fcb" param="id"/>
	${fcb.findCandidate() }
	<form method="post" action="updatecand.jsp">
		<input type="hidden" name="id" value="${fcb.cand.id}"><br/> <br/>
		Name: <input type="text" name="name" value="${fcb.cand.name }"><br/> <br/>
		Party: <input type="text" name="party" value="${fcb.cand.party }"><br/> <br/>
		Votes: <input type="text" name="votes" readonly="readonly" value="${fcb.cand.votes }"><br/> <br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>