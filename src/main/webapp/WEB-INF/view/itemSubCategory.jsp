<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<form class="form-horizontal form-bordered" id="createItemCategory" action="./createItemCategory.htm" method="post">

				<div class="row">
					<div class="col-md-6 col-sm-6">
						<select class="form-control" name="assetCategory.assetCategoryId" id="assetCategoryId" data-plugin-selectTwo >
												<option value="">
													<spring:message code="COMMON.LABEL.DROPDOWN.SELECT" />
												</option>
												<c:forEach items="${itemCategoryList}" var="itemCategoryList">
													<c:choose>
														<c:when test="${itemCategoryList.assetCategoryId eq assetSubCategory.assetCategory.assetCategoryId}">
															<option value="${itemCategoryList.assetCategoryId}" selected="selected">${itemCategoryList.assetCategoryName} | ${assetCategoryList.assetCategoryCode}</option>
														</c:when>
														<c:otherwise>
															<option value="${itemCategoryList.categoryId}">${itemCategoryList.categoryName} | ${itemCategoryList.categoryCode}</option>
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
								<input type="text" name="subCategoryName" class="form-control"
									id="subCategoryName" maxlength="9"
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
								<input type="text" name="subCategoryCode" class="form-control"
									id="subCategoryCode" maxlength="9"
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
							<input type="submit" class="btn btn-success"
								value=<spring:message code="COMMON.BUTTON.SAVE" /> /> <a
								href="assetCategory.htm"> <input type="button"
								class="btn btn-warning"
								value=<spring:message code="COMMON.BUTTON.BACK" /> /></a>
						</div>
					</div>
				</div>
			</form>
		</div>
	</div>
	<section class="panel">
		<header class="panel-heading">
			<div class="panel-actions">
				<c:choose>
					<c:when test="${not empty assetCategory.assetCategoryId}">
						<a href="#" class="fa fa-caret-up"></a>
						<c:set var="sectionHead" value="none"></c:set>
					</c:when>
					<c:when test="${empty assetCategory.assetCategoryId}">
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
			<table class="table table-bordered table-striped mb-none" id="datatable-default">
				<thead>
					<tr>
					    <th><spring:message code="PROJECT.COMMON.SLNO"/></th>
						<th><spring:message code="ITEM.CATEGORY.NAME" /></th>
						<th><spring:message code="ITEM.SUBCATEGORY.CODE" /></th>
						<th><spring:message code="ITEM.SUBCATEGORY.CODE" /></th>
												
					</tr>
				</thead>
				<tbody>
				    <c:set scope="page" var="row" value="1" />
					<c:forEach items="${itemCategoryList}" var="itemCategoryList">
						<tr class="gradeX">
						    <td>${row}</td>
						    <td>${itemCategoryList.itemCategory.categoryName}</td>
							<td>${itemCategoryList.subCategoryName}</td>
							<td>${itemCategoryList.subCategoryCode}</td>
											
						</tr>
						<c:set value="${row+1}" var="row" />
					</c:forEach>
				</tbody>
			</table>	
		</div>
	</section>
</body>
</html>