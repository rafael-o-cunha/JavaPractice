<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Pet" %>

<%
	List<Pet> pets = (List<Pet>) request.getAttribute("pets");
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Pets:</h1>

	<table border ="1">
		<thead>
			<tr>
				<th>ID</th>
		        <th>Name</th>
		        <th>Species</th>
		        <th>Age</th>
		        <th>Vaccinated</th>
			</tr>
		</thead>
		<tbody>

            <% for (Pet pet : pets) { %>
                <tr>
                    <td><%= pet.getId() %></td>
                    <td><%= pet.getName() %></td>
                    <td><%= pet.getSpecies() %></td>
                    <td><%= pet.getAge() %></td>
                    <td><%= pet.getVaccinated() %></td>
                </tr>
            <% } %>

        </tbody>
    </table>
</body>
</html>