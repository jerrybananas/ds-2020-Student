<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">
	<a href="<c:url value="/admin/staff/add"></c:url>"> Add
		User</a>


	<table class="ui celled  striped table">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="std" items="${users}">

			<tr>
				<td>${std.user_id}</td>
				<td>${std.user_first_name}</td>
				<td>${std.user_last_name}</td>
				<td><a
					href="<c:url value="/admin/staff/${std.user_id}"></c:url>"><i
						class="unhide icon"></i> Update</a></td>
				<td><a
					href="<c:url value="/admin/staff/delete/${std.user_id}"></c:url>"><i
						class="remove user icon"></i> Delete</a>
			</tr>
		</c:forEach>
	</table>

</div>