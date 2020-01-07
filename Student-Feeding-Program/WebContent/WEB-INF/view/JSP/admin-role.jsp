<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">
	<a href="<c:url value="/admin/roles/add"></c:url>"> Add Role</a>
	<table class="ui celled  striped table">
		<thead>
			<tr>
				<th>Role Name</th>
				<th>Role User ID</th>
			</tr>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="std" items="${roles}">

			<tr>
				<td>${std.role_name}</td>
				<td>${std.role_user_id}</td>
				<td><a
					href="<c:url value="/roles/services/${std.role_id}"></c:url>"><i
						class="unhide icon"></i> Update</a></td>
				<td><a
					href="<c:url value="/admin/roles/delete/${std.role_id}"></c:url>"><i
						class="remove user icon"></i> Delete</a>
			</tr>
		</c:forEach>
	</table>

</div>