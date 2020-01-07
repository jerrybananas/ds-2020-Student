<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">
	<a href="<c:url value="/admin/services/add"></c:url>"> Add Service</a>
	<table class="ui celled  striped table">
		<thead>
			<tr>
				<th>Service Name</th>
				<th>Service URL</th>
			</tr>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="std" items="${services}">

			<tr>
				<td>${std.service_name}</td>
				<td>${std.service_url}</td>
				<td><a
					href="<c:url value="/admin/services/${std.service_id}"></c:url>"><i
						class="unhide icon"></i> Update</a></td>
				<td><a
					href="<c:url value="/admin/services/delete/${std.service_id}"></c:url>"><i
						class="remove user icon"></i> Delete</a>
			</tr>
		</c:forEach>
	</table>

</div>