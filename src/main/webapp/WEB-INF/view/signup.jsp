<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- start: page -->
		<section class="body-sign">
			<div class="center-sign">
				<div class="panel panel-sign">
					<div class="panel-title-sign mt-xl text-right">
						<h2 class="title text-uppercase text-bold m-none"><i class="fa fa-user mr-xs"></i> Sign Up</h2>
					</div>
					<div class="panel-body">
							<p class="text-success">
								 <c:if test="${not empty message}">
								 	<spring:message code="HOME.SIGNUP.SUCCESS"/>
								 </c:if>
							</p>
							<p class="text-warning">
								<c:if test="${not empty error}">
									<spring:message code="HOME.SIGNUP.ERROR"/>
								 </c:if>
							</p>
						 <br>
						<form action="signup.htm" method="post">
							 <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
							<div class="form-group mb-none">
								<div class="row">
									<div class="col-sm-6 mb-lg">
										<label><spring:message code="HOME.REGISTER.FIRSTNAME"/></label>
										<input name="firstname" type="text" class="form-control input-lg" />
									</div>
									<div class="col-sm-6 mb-lg">
										<label><spring:message code="HOME.REGISTER.LASTNAME"/></label>
										<input name="lastname" type="text" class="form-control input-lg" />
									</div>
								</div>
							</div>
							
							<div class="form-group mb-lg">
								<label><spring:message code="HOME.REGISTER.EMAIL"/></label>
								<input name="email" type="email" class="form-control input-lg" />
							</div>

							<div class="form-group mb-none">
								<div class="row">
									<div class="col-sm-6 mb-lg">
										<label><spring:message code="HOME.REGISTER.PASSWORD"/></label>
										<input name="password" type="password" class="form-control input-lg" />
									</div>
									<div class="col-sm-6 mb-lg">
										<label><spring:message code="HOME.REGISTER.CONFPASSWORD"/></label>
										<input name="passwordConfirm" type="password" class="form-control input-lg" />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-sm-8">
									<div class="checkbox-custom checkbox-default">
										<input id="AgreeTerms" name="agreeterms" type="checkbox"/>
										<label for="AgreeTerms">I agree with <a href="#">terms of use</a></label>
									</div>
								</div>
								<div class="col-sm-4 text-right">
									<button type="submit" class="btn btn-primary hidden-xs">Sign Up</button>
									<button type="submit" class="btn btn-primary btn-block btn-lg visible-xs mt-lg">Sign Up</button>
								</div>
							</div>

							<span class="mt-lg mb-lg line-thru text-center text-uppercase">
								<span>or</span>
							</span>

							<div class="mb-xs text-center">
								<a class="btn btn-facebook mb-md ml-xs mr-xs">Connect with <i class="fa fa-facebook"></i></a>
								<a class="btn btn-twitter mb-md ml-xs mr-xs">Connect with <i class="fa fa-twitter"></i></a>
							</div>

							<p class="text-center">Already have an account? <a href="login.htm">Sign In!</a>

						</form>
					</div>
				</div>

				<p class="text-center text-muted mt-md mb-md">&copy; Copyright 2014. All Rights Reserved.</p>
			</div>
		</section>
		<!-- end: page -->

