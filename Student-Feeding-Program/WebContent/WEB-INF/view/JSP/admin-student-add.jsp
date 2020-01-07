<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">


	<h1>Select Student</h1>
	<hr>


	<div id="content" style="float: left">
		<form action="add-final" method="post">

			<p>
				First Name<br> <input type="text" name="student_first_name"
					size="20" />
			</p>
			<p>
				Last Name<br> <input type="text" name="student_last_name"
					size="20" />
			</p>
			<p>
				Mail<br> <input type="text" name="student_mail" size="20" />
			</p>
			<p>
				Password<br> <input type="text" name="student_password"
					size="20" />
			</p>

			University - (${student.student_uni})<br> <select name="uni">
				<c:forEach var="uni" items="${unis}">
					<option>${uni.getUni_name()}</option>
				</c:forEach>
			</select> <br>

			<p>
				<input type="submit" value="Update">
			</p>
		</form>
	</div>



</div>








