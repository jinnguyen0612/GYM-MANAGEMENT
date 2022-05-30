<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header id="header" class="header fixed-top d-flex align-items-center">

	<!--  flag -->
	<div class="alert-flag" aType='${message.type}'
		aMessage="${message.message }"></div>
	<div class="modal-flag" idModal="${idModal}"></div>
	<div class="customerId-flag" data="${customerId}"></div>
	<!-- end flag  -->
	<div class="d-flex align-items-center justify-content-between">
		<a href="admin/index.htm" class="logo d-flex align-items-center">
			<img src="assets/img/logo.png" alt="" /> <span
			class="d-none d-lg-block">PTIT GYM</span>
		</a> <i class="bi bi-list toggle-sidebar-btn"></i>
	</div>
	<!-- End Logo -->

	<nav class="header-nav ms-auto">
		<ul class="d-flex align-items-center">
			<li class="nav-item d-block d-lg-none"><a
				class="nav-link nav-icon search-bar-toggle" href="#"> <i
					class="bi bi-search"></i>
			</a></li>
			<!-- End Search Icon-->

			<li class="nav-item dropdown"><a class="nav-link nav-icon"
				href="#" data-bs-toggle="dropdown"> <i class="bi bi-bell"></i> <span
					class="badge bg-primary badge-number">4</span>
			</a> <!-- End Notification Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow notifications">
					<li class="dropdown-header">You have 4 new notifications <a
						href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View
								all</span></a>
					</li>
					<li>
						<hr class="dropdown-divider" />
					</li>

					<li class="notification-item"><i
						class="bi bi-exclamation-circle text-warning"></i>
						<div>
							<h4>Lorem Ipsum</h4>
							<p>Quae dolorem earum veritatis oditseno</p>
							<p>30 min. ago</p>
						</div></li>

					<li>
						<hr class="dropdown-divider" />
					</li>

					<li class="notification-item"><i
						class="bi bi-x-circle text-danger"></i>
						<div>
							<h4>Atque rerum nesciunt</h4>
							<p>Quae dolorem earum veritatis oditseno</p>
							<p>1 hr. ago</p>
						</div></li>

					<li>
						<hr class="dropdown-divider" />
					</li>

					<li class="notification-item"><i
						class="bi bi-check-circle text-success"></i>
						<div>
							<h4>Sit rerum fuga</h4>
							<p>Quae dolorem earum veritatis oditseno</p>
							<p>2 hrs. ago</p>
						</div></li>

					<li>
						<hr class="dropdown-divider" />
					</li>

					<li class="notification-item"><i
						class="bi bi-info-circle text-primary"></i>
						<div>
							<h4>Dicta reprehenderit</h4>
							<p>Quae dolorem earum veritatis oditseno</p>
							<p>4 hrs. ago</p>
						</div></li>

					<li>
						<hr class="dropdown-divider" />
					</li>
					<li class="dropdown-footer"><a href="#">Show all
							notifications</a></li>
				</ul> <!-- End Notification Dropdown Items --></li>
			<!-- End Notification Nav -->

			<li class="nav-item dropdown"><a class="nav-link nav-icon"
				href="#" data-bs-toggle="dropdown"> <i
					class="bi bi-chat-left-text"></i> <span
					class="badge bg-success badge-number">3</span>
			</a> <!-- End Messages Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow messages">
					<li class="dropdown-header">You have 3 new messages <a
						href="#"><span class="badge rounded-pill bg-primary p-2 ms-2">View
								all</span></a>
					</li>
					<li>
						<hr class="dropdown-divider" />
					</li>

					<li class="message-item"><a href="#"> <img
							src="assets/img/messages-1.jpg" alt="" class="rounded-circle" />
							<div>
								<h4>Maria Hudson</h4>
								<p>Velit asperiores et ducimus soluta repudiandae labore
									officia est ut...</p>
								<p>4 hrs. ago</p>
							</div>
					</a></li>
					<li>
						<hr class="dropdown-divider" />
					</li>

					<li class="message-item"><a href="#"> <img
							src="assets/img/messages-2.jpg" alt="" class="rounded-circle" />
							<div>
								<h4>Anna Nelson</h4>
								<p>Velit asperiores et ducimus soluta repudiandae labore
									officia est ut...</p>
								<p>6 hrs. ago</p>
							</div>
					</a></li>
					<li>
						<hr class="dropdown-divider" />
					</li>

					<li class="message-item"><a href="#"> <img
							src="assets/img/messages-3.jpg" alt="" class="rounded-circle" />
							<div>
								<h4>David Muldon</h4>
								<p>Velit asperiores et ducimus soluta repudiandae labore
									officia est ut...</p>
								<p>8 hrs. ago</p>
							</div>
					</a></li>
					<li>
						<hr class="dropdown-divider" />
					</li>

					<li class="dropdown-footer"><a href="#">Show all messages</a>
					</li>
				</ul> <!-- End Messages Dropdown Items --></li>
			<!-- End Messages Nav -->

			<li class="nav-item dropdown pe-3"><a
				class="nav-link nav-profile d-flex align-items-center pe-0" href="#"
				data-bs-toggle="dropdown"> <span
					class="d-none d-md-block dropdown-toggle ps-2">${admin.staff.name}</span>
			</a> <!-- End Profile Iamge Icon -->

				<ul
					class="dropdown-menu dropdown-menu-end dropdown-menu-arrow profile">
					<li class="dropdown-header">
						<h6>${admin.staff.name}</h6>
					</li>
					<li>
						<hr class="dropdown-divider" />
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="admin/profile.htm"> <i class="bi bi-person"></i> <span>Thông
								tin của tôi</span>
					</a></li>
					<li>
						<hr class="dropdown-divider" />
					</li>

					<li><a class="dropdown-item d-flex align-items-center"
						href="admin/logout.htm"> <i class="bi bi-box-arrow-right"></i>
							<span>Đăng xuất</span>
					</a></li>
				</ul> <!-- End Profile Dropdown Items --></li>
			<!-- End Profile Nav -->
		</ul>
	</nav>
	<!-- End Icons Navigation -->
</header>