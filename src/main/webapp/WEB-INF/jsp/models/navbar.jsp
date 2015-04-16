<!-- Navigation -->
<nav class="navbar navbar-inverse navbar-fixed-top narbar-img"
	role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home"> <img src="${pageContext.request.contextPath}/images/logo.png"
				width="229" height="74" alt="">
			</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul style="font-size: 18px" class="nav navbar-nav">
				<li><a href="#">Creare Account</a></li>
				<li class="dropdown">
		          <a style="font-size: 18px;" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
		          	Funds <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li style="padding-bottom: 10px">
		            	<a href="support/viewAddFunds">
		            		<i class="glyphicon glyphicon-credit-card"></i>  Add funds
	            		</a>
            		</li>
            		<li style="padding-bottom: 10px">
		            	<a href="support/viewTransferBySupport">
		            		<i class="glyphicon glyphicon-credit-card"></i>  Transfer
	            		</a>
            		</li>
            		<li style="padding-bottom: 10px">
		            	<a href="support/viewWithdraw">
		            		<i class="glyphicon glyphicon-credit-card"></i>  Withdraw
	            		</a>
            		</li>
		          </ul>
		        </li>
			</ul>
			<!-- Dropdow menu -->
			<ul class="nav navbar-nav navbar-right">
		        <li class="dropdown">
		          <a style="font-size: 18px;" href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
		          	<i class="glyphicon glyphicon-th-large"></i>  ${sessionScope.user.loginId } <span class="caret"></span></a>
		          <ul class="dropdown-menu" role="menu">
		            <li style="padding-bottom: 10px"><a href="#"><i class="glyphicon glyphicon-user"></i>  Edit profile</a></li>
		            <li><a href="#"><i class="glyphicon glyphicon-off"></i>  Sign out</a></li>
		          </ul>
		        </li>
	      	</ul>
		</div>
	</div>
</nav>