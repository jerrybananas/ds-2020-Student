<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">


	<a href="<c:url value="/admin/students/add"></c:url>"> Add
		Student</a>


	<table class="ui celled  striped table">
		<thead>
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
			</tr>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="std" items="${students}">

			<tr>
				<td>${std.getStudent_id()}</td>
				<td>${std.getStudent_first_name()}</td>
				<td>${std.getStudent_last_name()}</td>
				<td><a
					href="<c:url value="/admin/students/${std.getStudent_id()}"></c:url>"><i
						class="unhide icon"></i> Update</a></td>
				 <td><a
					href="<c:url value="/admin/students/delete/${std.getStudent_id()}"></c:url>"><i
						class="remove user icon"></i> Delete</a>
			</tr>
		</c:forEach>
	</table>

</div>








