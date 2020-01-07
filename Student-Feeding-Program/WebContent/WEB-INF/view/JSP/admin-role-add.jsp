<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">





	<div id="content" style="float: left">
		<form action="addFinal" method="post">

			<br> Role<br> <select name=role>
				<option>STAFF</option>
				<option>MANAGER</option>
			</select> <br> User ID<br> <select name=user_id>
				<c:forEach var="users" items="${users}">
					<option>${users.user_id}</option>
				</c:forEach>
			</select>


			<p>
				<input type="submit" value="Add">
			</p>
		</form>
	</div>



</div>








