<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 


 <!-- Navbar -->
  <nav class="main-header navbar navbar-expand navbar-white navbar-light">
    <!-- Left navbar links -->
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" data-widget="pushmenu" href="#" role="button"><i class="fas fa-bars"></i></a>
      </li>
    </ul>
  </nav>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
      <span class="brand-text font-weight-light">ServiceAutoRapid</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          
          <li class="nav-item">
            <a href="<c:url value="/list.htm"/>" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
             Pagina de start
             </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="<c:url value="/listClient.htm"/>" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
               Lista Clienti
              </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="<c:url value="/listAngajat.htm"/>" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
               Lista Angajati
                </p>
            </a>
          </li>
          <li class="nav-item">
            <a href="<c:url value="/listMasina.htm"/>" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
              Lista Masini
              
              </p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
