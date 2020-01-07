<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">


	<h1>Select Student</h1>
	<hr>


	<div id="content" style="float: left">
		<form action="update" method="post">

			<p>ID: ${student.student_id}</p>
			<p>
				First Name<br> <input type="text" name="student_first_name"
					size="20" value="${student.student_first_name}" />
			</p>
			<p>
				Last Name<br> <input type="text" name="student_last_name"
					size="20" value="${student.student_last_name}" />
			</p>
			<p>
				Mail<br> <input type="text" name="student_mail" size="20"
					value="${student.student_mail}" />
			</p>
			<p>
				Password<br> <input type="text" name="student_password"
					size="20" value="${student.student_password}" />
			</p>

			University - (${student.student_uni})<br> <select name="uni">
				<c:forEach var="uni" items="${unis}">
					<option>${uni.getUni_name()}</option>
				</c:forEach>
			</select>

			<p>
				Are both of your parents unemployed?<br>
				<c:choose>
					<c:when test="${student.isBoth_parents_unemployed()==true}">
						<input type="radio" name="both_parents_unemployed" value="true"
							checked> True<br>
						<input type="radio" name="both_parents_unemployed" value="false"> False<br>
					</c:when>
					<c:otherwise>
						<input type="radio" name="both_parents_unemployed" value="true"> True<br>
						<input type="radio" name="both_parents_unemployed" value="false"
							checked> False<br>
					</c:otherwise>
				</c:choose>
			</p>


			<p>
				Number of siblings that are attending university<br> <input
					type="text" name="siblings_at_university" size="20"
					value="${student.siblings_at_university}" />
			</p>

			<p>
				Family income<br> <input type="text" name="familyIncome"
					size="20" value="${student.getFamily_income()}" />
			</p>

			<p>
				Are you from the same city as the university?<br>
				<c:choose>
					<c:when test="${student.isSame_city()==true}">
						<input type="radio" name="same_city" value="true" checked> True<br>
						<input type="radio" name="same_city" value="false"> False<br>
					</c:when>
					<c:otherwise>
						<input type="radio" name="same_city" value="true"> True<br>
						<input type="radio" name="same_city" value="false" checked> False<br>
					</c:otherwise>
				</c:choose>
			</p>

			<p>
				Student points<br> <input type="text"
					name="student_points" size="20"
					value="${student.getStudent_points()}" />
			</p>
			
			<p>
				Is student verified?<br>
				<c:choose>
					<c:when test="${student.isStudent_verified()==true}">
						<input type="radio" name="student_verified" value="true" checked> True<br>
						<input type="radio" name="student_verified" value="false"> False<br>
					</c:when>
					<c:otherwise>
						<input type="radio" name="student_verified" value="true"> True<br>
						<input type="radio" name="student_verified" value="false" checked> False<br>
					</c:otherwise>
				</c:choose>
			</p>
			
			<p>
				Are student's papers verified?<br>
				<c:choose>
					<c:when test="${student.isPapers_verified()==true}">
						<input type="radio" name="same_city" value="true" checked> True<br>
						<input type="radio" name="same_city" value="false"> False<br>
					</c:when>
					<c:otherwise>
						<input type="radio" name="same_city" value="true"> True<br>
						<input type="radio" name="same_city" value="false" checked> False<br>
					</c:otherwise>
				</c:choose>
			</p>



			<p>
				<input type="submit" value="Update">
			</p>
		</form>
	</div>



</div>








