<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="ui segment bg">


	<form:form action="checkStudentLogin" modelAttribute="user" method="POST" class="ui form">
		<h3 style="color: Green" align="center">Student Login</h3>
		<div class="field">
			<label>Email</label>
			<form:input required="required" path="user_mail" />
		</div>
		<div class="field">
			<label>Password</label>
			<form:input required="required" path="user_password" type="password"/>
		</div>
		<button class="ui button" type="submit">Student Login</button>
	</form:form>



	<form:form action="checkLogin" modelAttribute="user" method="POST"
		class="ui form">
		<h3 style="color: Red" align="center">Staff Login</h3>
		<div class="field">
			<label>Email</label>
			<form:input required="required" path="user_mail" />
		</div>
		<div class="field">
			<label>Password</label>
			<form:input required="required" path="user_password" type="password"/>
		</div>
		<button class="ui button" type="submit">Staff login</button>
	</form:form>




</div>

