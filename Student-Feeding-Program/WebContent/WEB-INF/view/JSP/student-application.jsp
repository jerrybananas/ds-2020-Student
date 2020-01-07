<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">
	<div id="main">
		<h1>Update User</h1>
		<hr>
		<div id="content" style="float: left">
			<form action="updateForm" method="post">

				<p>
					Number of siblings that are attending university <br> <input
						type="text" name="uniSiblings" size="20"
						value="${student.getSiblings_at_university()}" />
				</p>
				<p>
					Family income<br> <input type="text" name="familyIncome"
						size="20" value="${student.getFamily_income()}" />
				</p>
				<p>
					Are both of your parents unemployed?<br>
					<c:choose>
						<c:when test="${student.isBoth_parents_unemployed()==true}">
							<input type="radio" name="unparents" value="true" checked> True<br>
							<input type="radio" name="unparents" value="false"> False<br>
						</c:when>
						<c:otherwise>
							<input type="radio" name="unparents" value="true"> True<br>
							<input type="radio" name="unparents" value="false" checked> False<br>
						</c:otherwise>
					</c:choose>
				</p>
				<p>
					Are you from the same city as the university?<br>
					<c:choose>
						<c:when test="${student.isSame_city()==true}">
							<input type="radio" name="sameCity" value="true" checked> True<br>
							<input type="radio" name="sameCity" value="false"> False<br>
						</c:when>
						<c:otherwise>
							<input type="radio" name="sameCity" value="true"> True<br>
							<input type="radio" name="sameCity" value="false" checked> False<br>
						</c:otherwise>
					</c:choose>
				</p>
				<p>
					<input type="submit" value="Sumbit Form">
				</p>
			</form>
		</div>



		<div id="content2" style="float: right">
			<form>
				<p>
					Your points<br>
					<c:choose>
						<c:when test="${student.isPapers_verified()==true}">
							<input type="text" name="points" size="20"
								value="${student.getStudent_points()}" />
						</c:when>
						<c:otherwise>							
							<input type="text" size="20" value=0 /><br>
							Papers are not yet verified, so you don't have any points yet.<br>
						</c:otherwise>
					</c:choose>
				</p>
				<p>
					Student verified<br>
					<c:choose>
						<c:when test="${student.isStudent_verified()==true}">
							<font color="blue">True</font>
						</c:when>
						<c:otherwise>
							<font color="red">False</font>
						</c:otherwise>
					</c:choose>
				</p>
				<p>
					Papers verified<br>
					<c:choose>
						<c:when test="${student.isPapers_verified()==true}">
							<font color="blue">True </font>
						</c:when>
						<c:otherwise>
							<font color="red">False</font>
						</c:otherwise>
					</c:choose>
				</p>
			</form>
		</div>
	</div>
</div>