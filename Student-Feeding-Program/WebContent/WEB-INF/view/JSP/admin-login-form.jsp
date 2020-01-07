<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="ui segment bg">


	<form:form action="checkAdminLogin" modelAttribute="admin" method="POST"
		class="ui form">
		<h3 style="color: Red" align="center">Admin Login</h3>
		<div class="field">
			<label>Email</label>
			<form:input required="required" path="mail" />
		</div>
		<div class="field">
			<label>Password</label>
			<form:input required="required" path="password" type="password"/>
		</div>
		<button class="ui button" type="submit">Admin login</button>
	</form:form>




</div>

