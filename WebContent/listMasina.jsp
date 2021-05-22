<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>MercedesBenz</title>

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
                <h5 class="m-0">Lista masini</h5>
              </div>
              <div class="card-body">
              
              <table class="table table-striped">
				<tr>
					<td>ID</td>
					<td>Marca</td>
					<td>Model</td>
					<td>Culoare</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<c:forEach var="st" items="${cars}">
					<tr>
						<td><c:out value="${st.id}"/></td> 
						<td><c:out value="${st.marca}"/></td>
						<td><c:out value="${st.model}"/></td> 
						<td><c:out value="${st.culoare}"/></td>
						<td><a class="btn btn-info" href="<c:url value="/detalii.htm?id=${st.id}"/>">Detalii</a></td>
						<td><a class="btn btn-success" href="<c:url value="/editare-masina.htm?id=${st.id}"/>">Editare</a></td>
						<td><a class="btn btn-danger" href="<c:url value="/delete.htm?id=${st.id}"/>">Delete</a></td>
					</tr>
				</c:forEach>
				</table>
				<br/><br/>
				<a class="btn btn-primary" href="<c:url value="/adaugare-student.htm"/>">Adaugare masina</a>
           
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