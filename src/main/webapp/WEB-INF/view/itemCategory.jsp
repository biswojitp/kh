<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="resources/javascripts/common.js"></script>
<script src="resources/javascripts/propertymngmnt/propertyProjectBuilding.js"></script>
<script type="text/javascript">



function edit(categoryId){
	        bootbox.confirm ({
	    	message: "Do you want to edit Project details ?",
	    	callback: function (proceed)
	    	{
	    	 if(proceed)
	     		 
	    	 {
	    	   document.getElementById("propertyBuildingId").value=categoryId;
	    	   $('#editBuildingId').submit();
	    	 }
	    	}
	    })
	}

</script>
<script type="text/javascript">

function check()
{
	if($("#categoryName").val() == "")
	{
		 bootbox.alert("Please Enter category name");
		 return false;
	}
	if($("#categoryCode").val() == "")
	{
		 bootbox.alert("Please Enter category code");
		 return false;
	}
	else
	{
		$('#createCategoryDetails').submit(); 
	}
}
</script>
<section role="main" class="content-body">
	<header class="page-header">
		<h2>
			<spring:message code="ITEM.CATEGORY.TITLE" />
		</h2>
		<%-- <div class="right-wrapper pull-right">
			<ol class="breadcrumbs">
				<li> <a href="./"> <i class="fa fa-home"></i></a></li>
				<li><span><spring:message code="PROPERTY.MNGMNTTREATMENTPLANT.TITLE" /></span></li>
			</ol>
		</div> --%>
	</header>

	<%@ include file="/WEB-INF/view/message.jsp"%> 

	<div class="row">
		<div class="col-lg-12">
			<section class="panel">
				<header class="panel-heading">
					<div class="panel-actions">
						<c:choose>
							<c:when test="${not empty itemCategoryLists.categoryId}">
								<a href="#" class="fa fa-caret-down"></a>
								<c:set var="sectionHead" value="block"></c:set>
							</c:when>
							<c:when test="${empty itemCategoryLists.categoryId}">
								<a href="#" class="fa fa-caret-up"></a>
								<c:set var="sectionHead" value="none"></c:set>
							</c:when>
						</c:choose>
					</div>
					<h2 class="panel-title">
						<c:choose>
							<c:when test="${not empty itemCategoryLists.categoryId}">
								<h2 class="panel-title">
									<span><spring:message code="ITEM.CATEGORY.EDIT" /></span>
								</h2>
							</c:when>
							<c:otherwise>
								<h2 class="panel-title">
									<span><spring:message code="ITEM.CATEGORY.CREATE" /></span>
								</h2>
							</c:otherwise>
						</c:choose>  
					</h2>
				</header>

				<div class="panel-body" style="display:${sectionHead}">
					<div class="col-md-12">
						<form class="form-horizontal form-bordered" id="createCategoryDetails" action="./createCategoryDetails.htm" method="post">
						<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
						<input type="hidden" name="categoryId" value="${itemCategoryLists.categoryId}" id="categoryId"/>
						
						
						<div class="row">
					<div class="col-md-6 col-sm-6">
						<div class="form-group">
							<label class="col-md-12 required" for="inputDefault"><spring:message
									code="ITEM.CATEGORY.NAME" />:</label>
							<div class="col-md-12">
								<input type="text" name="categoryName" class="form-control"
									id="categoryName" maxlength="30"
									onchange="validateNameAndCode(this)"
									value="${itemCategoryLists.categoryName}" />
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-3">
						<div class="form-group">
							<label class="col-md-12 required" for="inputDefault"><spring:message
									code="ITEM.CATEGORY.CODE" />:</label>
							<div class="col-md-12">
								<input type="text" name="categoryCode" class="form-control"
									id="categoryCode" maxlength="9"
									onchange="validateNameAndCode(this)"
									value="${itemCategoryLists.categoryCode}">
							</div>
						</div>
					</div>
					<div class="col-md-3 col-sm-3">
						<label class="col-md-12 required" for="inputDefault"><spring:message
								code="ITEM.CATEGORY.ISACTIVE" />:</label> <select
							class="form-control" id="isActive" name="isActive">
							<option value="">
								<spring:message code="COMMON.LABEL.DROPDOWN.SELECT" />
							</option>
							<c:choose>
								<c:when test="${itemCategoryLists.isActive eq true}">
									<option value="1" selected="selected">Yes</option>
									<option value="0">No</option>
								</c:when>
								<c:when test="${itemCategoryLists.isActive eq false}">
									<option value="0" selected="selected">No</option>
									<option value="1">Yes</option>

								</c:when>
								<c:otherwise>
									<option value="0">No</option>
									<option value="1">Yes</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>
				</div>
							<div class="row">
					
					<div class="col-md-6 col-sm-6">
						<div class="form-group">
							<label class="col-md-12" for="inputDefault"><spring:message
									code="ITEM.CATEGORY.DESCRIPTION" />:</label>
							<div class="col-md-12">
								<textarea name="description" class="form-control"
									maxlength="190" id="description">${itemCategoryLists.description} </textarea>
							</div>
						</div>
					</div>
				</div>
							
							<div class="row">
								<div class="col-sm-12" style="margin-top: 30px;">
									<div class="form-group text-center">
									<c:if test="${not empty itemCategoryLists.categoryId}"> 
									<button type="submit" class="btn btn-success" >
											<spring:message code="COMMON.BUTTON.UPDATE"></spring:message>
										</button>
									
									</c:if>
									<c:if test="${empty itemCategoryLists.categoryId}">
										<button type="button" class="btn btn-success" onclick="check()"><spring:message code="COMMON.BUTTON.SAVE"></spring:message></button>
										</c:if>
										<a href="./treatmentplant.htm"><input type="button" class="btn btn-danger" value=<spring:message code="COMMON.BUTTON.BACK"></spring:message>></a>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>	
			</section>
			<section class="panel">
				<header class="panel-heading">
					<div class="panel-actions">
						<c:choose>
							<c:when test="${not empty itemCategoryLists.categoryId}">
								<a href="#" class="fa fa-caret-up"></a>
								<c:set var="sectionHead" value="none"></c:set>
							</c:when>
							<c:when test="${empty itemCategoryLists.categoryId}">
								<a href="#" class="fa fa-caret-down"></a>
								<c:set var="sectionHead" value="block"></c:set>
							</c:when>
						</c:choose>
					</div>
					<h2 class="panel-title">
						<spring:message code="ITEM.CATEGORY.LIST" />
					</h2>
				</header>
				<div class="panel-body" style="display:${sectionHead}">
					<form id="editBuildingId" action="./itemCategory.htm" method="post">
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
						<input type="hidden" name="categoryId" id="propertyBuildingId"> 
						<table class="table table-bordered table-striped mb-none" id="datatable-default">
				<thead>
					<tr>
					    <th><spring:message code="PROJECT.COMMON.SLNO"/></th>
						<th><spring:message code="ITEM.CATEGORY.NAME" /></th>
						<th><spring:message code="ITEM.CATEGORY.CODE" /></th>
						<th><spring:message code="COMMON.LABEL.OPTION" /></th>
												
					</tr>
				</thead>
				<tbody>
				    <c:set scope="page" var="row" value="1" />
					<c:forEach items="${itemCategoryList}" var="itemCategoryList">
						<tr class="gradeX">
						    <td>${row}</td>
							<td>${itemCategoryList.categoryName}</td>
							<td>${itemCategoryList.categoryCode}</td>
							<td>
								<a class="btn btn-xs btn-circle btn-warning" onclick="edit(${itemCategoryList.categoryId})"> 
								<i class="fa fa-pencil" aria-hidden="true" title=<spring:message code="COMMON.LABEL.EDIT"/>></i>
								</a>
							</td>
											
						</tr>
						<c:set value="${row+1}" var="row" />
					</c:forEach>
				</tbody>
			</table>	
					</form>
				</div>
			</section>
		</div>
	</div>
</section>

