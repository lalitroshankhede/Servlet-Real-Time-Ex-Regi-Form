<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</head>
<body style="background-color: crimson;">

	<div class="container">

		<div class="row">

			<div class="col m3"></div>

			<div class="col m6">

				<div class="card">

					<div class="card-content">
						<h3 class="center-align">Register Here</h3>

						<!--  Creating Form -->

						<div class="form center-align">

							<form action="RegisterForm" method="post">

								<input type="text" name="user_name"
									placeholder="Enter Your Name"> <input type="password"
									name="user_password" placeholder="Enter  Password"> <input
									type="email" name="user_email" placeholder="Enter Email">

								<button type="submit" class="btn" onclick="submitData()">Submit</button>

							</form>

						</div>


						<!-- Creating Loader  -->

						<div class="loader center-align" style="margin-top: 20px;display:none;">

							<div class="preloader-wrapper active">
								<div class="spinner-layer spinner-red-only">
									<div class="circle-clipper left">
										<div class="circle"></div>
									</div>
									<div class="gap-patch">
										<div class="circle"></div>
									</div>
									<div class="circle-clipper right">
										<div class="circle"></div>
									</div>
								</div>
							</div>

							<h5>Please wait...</h5>

						</div>

					</div>


				</div>


			</div>

			<div class="col m3"></div>

		</div>
	</div>


 
<script type="text/javascript">

 function submitData()
 {
	 document.querySelector(".loader").style="display:block";
	 document.querySelector(".form").style="display:none";
 }

</script>

</body>
</html>