<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="javascripts/common.js"></script>
</head>
<body>
<div class="panel-body" style="display:${sectionHead}">
					<div class="col-md-12">
						<form class="form-horizontal form-bordered" id="createTreatmentPlant" action="./saveItemList.htm" method="post">
											
						<div class="row">
						<div class="col-md-6 col-sm-6">
									<div class="form-group">
										<label class="col-md-12 required" for="inputDefault"> <spring:message code="KITCHENHOME.ITEM.ITEMNAME" /></label>
										<div class="col-md-12">
											<input type="text" class="form-control" name="itemName" id="itemName" value="${treatmentPlantById.itemName}" maxlength="100" onchange ="validateNameAndCode(this)"  /> 
										</div>
									</div>
								</div>
								<div class="col-md-3 col-sm-3">
									<div class="form-group">
										<label class="col-md-12 required" for="inputDefault"> <spring:message code="KITCHENHOME.ITEM.HSN" /></label>
										<div class="col-md-12">
											<input type="text" class="form-control" name="HSN" id="HSN" value="${treatmentPlantById.HSN}"  maxlength="20" onchange ="validateNameAndCode(this)" /> 
										</div>
									</div>
								</div>
								<div class="col-md-3 col-sm-3">
									<div class="form-group">
										<label class="col-md-12 required" for="inputDefault"> <spring:message code="KITCHENHOME.ITEM.MANUFACTURE" /></label>
										<div class="col-md-12">
											<input type="text" class="form-control" name="mfr" id="mfr" value="${treatmentPlantById.mfr}"  maxlength="20" onchange ="validateNameAndCode(this)" /> 
										</div>
									</div>
								</div>
								<div class="col-md-3 col-sm-3">
									<div class="form-group">
										<label class="col-md-12 required" for="inputDefault"> <spring:message code="KITCHENHOME.ITEM.SGST" /></label>
										<div class="col-md-12">
											<input type="text" class="form-control" name="sgst" id="sgst" value="${treatmentPlantById.sgst}"  maxlength="20" onchange ="validateNameAndCode(this)" /> 
										</div>
									</div>
								</div>
								<div class="col-md-3 col-sm-3">
									<div class="form-group">
										<label class="col-md-12 required" for="inputDefault"> <spring:message code="KITCHENHOME.ITEM.CGST" /></label>
										<div class="col-md-12">
											<input type="text" class="form-control" name="cgst" id="cgst" value="${treatmentPlantById.cgst}"  maxlength="20" onchange ="validateNameAndCode(this)" /> 
										</div>
									</div>
								</div>
						</div>
																
						
								
							
							<div class="row">
							<button type="submit" class="btn btn-success" >
											<spring:message code="COMMON.BUTTON.SUBMIT"></spring:message>
										</button>
							</div>
							
						</form>
					</div>
				</div>	
</body>
</html>