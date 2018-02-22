<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<div>
		<form id="edit appUser" action="./updateAppUser" method="post">

			<div>
				<label>firstName</label>
				<div>
					<input type="text" name="firstName"	id="firstName" value="${appUser.firstName}" maxlength="100"  />
				</div>
			</div>
			
			<div>
				<label>lastName</label>
				<div>
					<input type="text" name="lastName"	id="lastName" value="${appUser.lastName}" maxlength="100"  />
				</div>
			</div>
			
			<div>
				<div>
					<input type="hidden" name=userId	id="userId" value="${appUser.userId}" maxlength="100"  />
				</div>
			</div>
			
			<div>
				<label>gender</label>
				<div>
					<input type="text" name="gender" id="gender" value="${appUser.gender}" maxlength="100"  />
				</div>
			</div>
			
			<div>
				<label>phone</label>
				<div>
					<input type="text" name="phone"	id="phone" value="${appUser.phone}" maxlength="100"  />
				</div>
			</div>
			
			<div>
				<label>email</label>
				<div>
					<input type="text" name="email"	id="email" value="${appUser.email}" maxlength="100"  />
				</div>
			</div>
			
			<div>
				<label>password</label>
				<div>
					<input type="text" name="password"	id="password" value="${appUser.password}" maxlength="100"  />
				</div>
			</div>
			
			<div>
                    <button type="submit">Submit</button>
                 
            </div>
			
			
		</form>
	</div> 

</body>

</html>
