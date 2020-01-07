<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">





	<div id="content" style="float: left">
		<form action="addFinal" method="post">

			<p>
				Service Name<br> <input type="text" name="service_name"
					size="20" />
			</p>
			<p>
				Service URL<br> <input type="text" name="service_url" size="20" />
			</p>
			<br> Role <br> <select name=service_role_name>
				<c:forEach var="roles" items="${roles}">
					<option>${roles}</option>
				</c:forEach>
			</select>


			<p>
				<input type="submit" value="Save">
			</p>
		</form>
	</div>



</div>








