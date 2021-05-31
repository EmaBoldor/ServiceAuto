<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adaugare masina</title>
<jsp:include page="/jsp/common/head_imports.jsp"/>
</head>
<body class="hold-transition sidebar-mini">
<div class="wrapper">

	<jsp:include page="/jsp/common/sidebar.jsp"/>
<!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
     <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-lg-12">
            <div class="card card-primary card-outline">
              <div class="card-header">
                <h5 class="m-0">Adaugare masina</h5>
              </div>
              <div class="card-body">
  
<form:form action="${pageContext.request.contextPath}/adaugare-masina-save.htm" method="post" modelAttribute="masinaForm">
<div class="form-group">
	<label for="marca">Marca</label><br/>
	<form:input path="marca" class="form-control"/>
</div>
<div class="form-group">
	<label for="model">Model</label><br/>
	<form:input path="model" class="form-control"/>
</div>
<div class="form-group">
	<label for="culoare">Culoare</label><br/>
	<form:input path="culoare" class="form-control"/>
</div>

<input type="submit" value="Salveaza" class="btn btn-primary"/><br/>

</form:form>
<br/><br/>
<a href="<c:url value="/listMasina.htm"/>">Inapoi la lista</a>


   </div>
            </div>
          </div>
          <!-- /.col-md-6 -->
        </div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

	<jsp:include page="/jsp/common/footer.jsp"/>
  
</div>
<!-- ./wrapper -->

<jsp:include page="/jsp/common/bottom_imports.jsp"/>

</body>
</html>