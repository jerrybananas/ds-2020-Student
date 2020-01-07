<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="ui segment bg">
	<h3>Welcome
		${user.getUser_first_name()}-${user.getUser_last_name()}, please
		choose one of the following services</h3>
	<table id="t01">
		<c:forEach var="tempRole" items="${roles}">
			<tr>
				<th>${tempRole.getRole_name()}</th>
			</tr>
			<c:forEach var="tempService" items="${services}">
				<c:choose>
					<c:when
						test="${tempRole.getRole_name()==tempService.getService_role_name()}">
						<tr>
							<td><a href="${tempService.getService_url()}">${tempService.getService_name()}</a></td>
						</tr>
					</c:when>
				</c:choose>
			</c:forEach>
		</c:forEach>
	</table>
	

</div>