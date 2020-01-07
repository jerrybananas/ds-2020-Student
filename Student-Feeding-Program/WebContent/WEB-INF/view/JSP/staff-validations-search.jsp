<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<div class="ui segment bg">

	<h1>Select Student</h1>
	<form:form action="verify-choose" modelAttribute="student"
		method="POST" class="ui form">		
				<div class="field">
					<label>Student Name:</label>
					<form:input required="required" path="student_first_name" />
				</div>
				<div class="field">
					<label>Student Surname:</label>
					<form:input required="required" path="student_last_name" />
				</div>
				<button class="ui button" type="submit">Search for
						Student</button>
	</form:form>

</div>








