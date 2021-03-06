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
                <h5 class="m-0">Lista clienti</h5>
              </div>
              <div class="card-body">
              
              <table class="table table-striped">
				<tr>
					<td>ID</td>
					<td>Nume</td>
					<td>Email</td>
					<td>Telefon</td>
					<td>Angajat</td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<c:forEach var="st" items="${customers}">
					<tr>
						<td><c:out value="${st.id}"/></td> 
						<td><c:out value="${st.nume}"/></td>
						<td><c:out value="${st.email}"/></td> 
						<td><c:out value="${st.telefon}"/></td>
						<td><c:out value="${angajati[st.angajatId]}"/></td>
						<td><a class="btn btn-info" href="<c:url value="/detaliiClient.htm?id=${st.id}"/>">Detalii</a></td>
						<td><a class="btn btn-success" href="<c:url value="/editare-client.htm?id=${st.id}"/>">Editare</a></td>
						<td><a class="btn btn-danger" href="<c:url value="/deleteClient.htm?id=${st.id}"/>">Delete</a></td>
					</tr>
				</c:forEach>
				</table>
				<br/><br/>
				<a class="btn btn-primary" href="<c:url value="/adaugare-client.htm"/>">Adaugare client</a>
           
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