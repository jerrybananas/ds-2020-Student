<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment bg">
	<h3>Welcome
		${student.getStudent_first_name()}-${student.getStudent_last_name()}, please
		choose one of the following services</h3>
	<table id="t01">
		<tr>
			<td><a href="application">Submit your application</a></td>
		</tr>
		<%--
		<tr>
			<td><a href="student-place">Check you current standing at the universities you have chosen</a></td>
		</tr>
		--%>

	</table>


</div>