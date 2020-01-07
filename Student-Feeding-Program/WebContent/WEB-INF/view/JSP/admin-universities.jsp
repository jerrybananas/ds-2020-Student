<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">
	<a href="<c:url value="/admin/universities/-1"></c:url>"> Add
		University</a>
	<table class="ui celled  striped table">
		<thead>
			<tr>
				<th>University ID</th>
				<th>University Name</th>
				<th>Group Number</th>
				<th>Seats</th>
				<th>Last Update</th>
			</tr>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempUni" items="${universities}">
			<tr>
				<td>${tempUni.uni_id}</td>
				<td>${tempUni.uni_name}</td>
				<td>${tempUni.eligible_uni_id}</td>
				<td>${tempUni.uni_seats}</td>
				<td>${tempUni.last_change}</td>
				<td><a
					href="<c:url value="/admin/universities/${tempUni.uni_id}"></c:url>"><i
						class="unhide icon"></i> Update</a>
				<%-- <td><a
					href="<c:url value="/admin/universities/delete/${tempUni.uni_id}"></c:url>"><i
						class="remove user icon"></i> Delete</a>--%>
			</tr>
		</c:forEach>
	</table>

</div>

