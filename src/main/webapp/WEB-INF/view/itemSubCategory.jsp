<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%-- <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%> --%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="resources/javascripts/common.js"></script>
<script
	src="resources/javascripts/propertymngmnt/propertyProjectBuilding.js"></script>
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
						<form class="form-horizontal form-bordered"
							id="createCategoryDetails" action="./createCategoryDetails.htm"
							method="post">
							<%-- <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> --%>
							<input type="hidden" name="categoryId"
								value="${itemCategoryLists.categoryId}" id="categoryId" />


							<div class="row">
								<div class="col-md-6 col-sm-6">
									<select class="form-control"
										name="assetCategory.assetCategoryId" id="assetCategoryId"
										data-plugin-selectTwo>
										<option value="">
											<spring:message code="COMMON.LABEL.DROPDOWN.SELECT" />
										</option>
										<c:forEach items="${itemCategoryList}" var="itemCategoryList">
											<c:choose>
												<c:when
													test="${itemCategoryList.categoryId eq itemSubCategoryList.itemCategory.categoryId}">
													<option value="${itemCategoryList.categoryId}"
														selected="selected">${itemCategoryList.categoryName}
														| ${itemCategoryList.categoryCode}</option>
												</c:when>
												<c:otherwise>
													<option value="${itemCategoryList.categoryId}">${itemCategoryList.categoryName}
														| ${itemCategoryList.categoryCode}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-3 col-sm-3">
									<div class="form-group">
										<label class="col-md-12 required" for="inputDefault"><spring:message
												code="ITEM.SUBCATEGORY.NAME" />:</label>
										<div class="col-md-12">
											<input type="text" name="subCategoryName"
												class="form-control" id="subCategoryName" maxlength="9"
												onchange="validateNameAndCode(this)"
												value="${assetCategory.subCategoryName}">
										</div>
									</div>
								</div>
								<div class="col-md-3 col-sm-3">
									<div class="form-group">
										<label class="col-md-12 required" for="inputDefault"><spring:message
												code="ITEM.SUBCATEGORY.CODE" />:</label>
										<div class="col-md-12">
											<input type="text" name="subCategoryCode"
												class="form-control" id="subCategoryCode" maxlength="9"
												onchange="validateNameAndCode(this)"
												value="${assetCategory.subCategoryCode}">
										</div>
									</div>
								</div>
							</div>
							<div class="row">

								<div class="col-md-6 col-sm-6">
									<div class="form-group">
										<label class="col-md-12" for="inputDefault"><spring:message
												code="ITEM.CATEGORY.DESCRIPTION" />:</label>
										<div class="col-md-12">
											<textarea name="description" class="form-control"
												maxlength="190" id="description">${assetCategory.description} </textarea>
										</div>
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-sm-12" style="margin-top: 30px;">
									<div class="form-group text-center">
										<c:if test="${not empty itemCategoryLists.categoryId}">
											<button type="submit" class="btn btn-success">
												<spring:message code="COMMON.BUTTON.UPDATE"></spring:message>
											</button>

										</c:if>
										<c:if test="${empty itemCategoryLists.categoryId}">
											<button type="button" class="btn btn-success"
												onclick="check()">
												<spring:message code="COMMON.BUTTON.SAVE"></spring:message>
											</button>
										</c:if>
										<a href="./treatmentplant.htm"><input type="button"
											class="btn btn-danger"
											value=<spring:message code="COMMON.BUTTON.BACK"></spring:message>></a>
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
						<input type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" /> <input type="hidden" name="categoryId"
							id="propertyBuildingId">
						<table class="table table-bordered table-striped mb-none"
							id="datatable-default">
							<thead>
								<tr>
									<th><spring:message code="PROJECT.COMMON.SLNO" /></th>
									<th><spring:message code="ITEM.CATEGORY.NAME" /></th>
									<th><spring:message code="ITEM.SUBCATEGORY.CODE" /></th>
									<th><spring:message code="ITEM.SUBCATEGORY.CODE" /></th>

								</tr>
							</thead>
							<tbody>
								<c:set scope="page" var="row" value="1" />
								<c:forEach items="${itemSubCategoryList}" var="itemSubCategoryList">
									<tr class="gradeX">
										<td>${row}</td>
										<td>${itemSubCategoryList.itemCategory.categoryName}</td>
										<td>${itemSubCategoryList.subCategoryName}</td>
										<td>${itemSubCategoryList.subCategoryCode}</td>
										<td><a class="btn btn-xs btn-circle btn-warning"
											onclick="edit(${itemSubCategoryList.SubCategoryId})"> <i
												class="fa fa-pencil" aria-hidden="true"
												title=<spring:message code="COMMON.LABEL.EDIT"/>></i>
										</a></td>

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
