<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">


	<h1>Select Student</h1>
	<hr>


	<div id="content" style="float: left">
		<form action="addFinal" method="post">

			<p>
				ID<br> <input type="text" name="user_id" size="20"
					value="${user.user_id}" />
			</p>
			<p>
				First Name<br> <input type="text" name="user_first_name"
					size="20" value="${user.user_first_name}" />
			</p>
			<p>
				Last Name<br> <input type="text" name="user_last_name"
					size="20" value="${user.user_last_name}" />
			</p>
			<p>
				Mail<br> <input type="text" name="user_mail" size="20"
					value="${user.user_mail}" />
			</p>
			<p>
				Password<br> <input type="text" name="user_password"
					size="20" value="${user.user_password}" />
			</p>

			<p>
				<input type="submit" value="Update">
			</p>
		</form>
	</div>



</div>








