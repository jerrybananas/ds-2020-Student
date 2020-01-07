<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">

	<table class="ui celled  striped table">
		<thead>
			<tr>
				<th>First name</th>
				<th>Last name</th>
				<th>University</th>
			</tr>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempStu" items="${students}">
			<tr>
				<td>${tempStu.getStudent_first_name()}</td>				
				<td>${tempStu.getStudent_last_name()}</td>
				<td>${tempStu.getStudent_uni()}</td>
				<td><a
					href="<c:url value="/user/verify-student/${tempStu.getStudent_id()}"></c:url>"><i
						class="unhide icon"></i> Verify</a>
			</tr>
		</c:forEach>
	</table>
</div>

