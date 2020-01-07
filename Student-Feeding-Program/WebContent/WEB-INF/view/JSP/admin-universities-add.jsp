<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="ui segment bg">

	<div id="content" style="float: left">
		<form action="add" method="post">

			<p>
				University Name:<br> <input type="text" name="uni_name"
					size="20" />
			</p>
			<p>
				University Grouping:<br> <input type="text"
					name="eligible_uni_id" size="20" />
			</p>
			<p>
				University seats for transfer Students:<br> <input type="text"
					name="uni_seats" size="20" />
			</p>

			<p>
				<input type="submit" value="Add">
			</p>
		</form>
	</div>
</div>

