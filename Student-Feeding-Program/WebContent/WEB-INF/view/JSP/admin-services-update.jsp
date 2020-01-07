<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">


	<h1>Select Service</h1>
	<hr>


	<div id="content" style="float: left">
		<form action="updateFinal" method="post">

			<p>
				ID<br> <input type="text" name="service_id" size="20"
					value="${service.service_id}" />
			</p>
			<p>
				Service Name<br> <input type="text" name="service_name"
					size="20" value="${service.service_name}" />
			</p>
			<p>
				Service URL<br> <input type="text" name="service_url"
					size="20" value="${service.service_url}" />
			</p>
			<br> Role - (${service.service_role_name}) <br> <select name=service_role_name>
					<c:forEach var="roles" items="${roles}">
						<option>${roles}</option>
					</c:forEach>
				</select>
			

			<p>
				<input type="submit" value="Update">
			</p>
		</form>
	</div>



</div>








