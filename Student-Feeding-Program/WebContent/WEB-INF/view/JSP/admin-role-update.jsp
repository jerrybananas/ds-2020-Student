<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">


	<h1>Select Role</h1>
	<hr>


	<div id="content" style="float: left">
		<form action="updateFinal" method="post">
			
			<br> Role - (${role.role_name})<br> <select name=role_name>
					<c:forEach var="roles" items="${roles}">
						<option>${roles.role_name}</option>
					</c:forEach>
				</select>			
			
			
			<br> User -  (${user.user_id})<br> <select name=user_id>
					<c:forEach var="roles" items="${users}">
						<option>${user.user_id}</option>
					</c:forEach>
				</select>
			

			<p>
				<input type="submit" value="Update">
			</p>
		</form>
	</div>



</div>








