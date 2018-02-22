<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<div>
		<form id="create login" action="./getLogin" method="get">
			
			<div>
				<label>email</label>
				<div>
					<input type="text" name="email"	id="email" value="${login.email}" maxlength="100"  />
				</div>
			</div>
			
			<div>
				<label>password</label>
				<div>
					<input type="text" name="password"	id="password" value="${login.password}" maxlength="100"  />
				</div>
			</div>
			
			<div>
                    <button type="login">Login</button>
                 
            </div>
			
			</form>
	</div> 

</body>

</html>
