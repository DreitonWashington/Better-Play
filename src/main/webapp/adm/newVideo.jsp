<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Videos Better-Play</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/dashStyle.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/videoStyle.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=DM+Sans&display=swap" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="side-bar">
			<header class="at">
				<h1>Better Play</h1>
			</header>
			<nav>
				<ul>
					<li>
						<a href="<%=request.getContextPath() %>/adm/dashboard.jsp">
							<div class="btn">
								<div class="content-in-button">
									<svg class="h-5 w-5 shrink-0" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
		  							<path stroke-linecap="round" stroke-linejoin="round" d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"></path>
									</svg>
								</div>
								<span>
									Dashboard
								</span>							
							</div>
						</a>
					</li>
					<li>
						<a>
							<div class="active btn">
								<div class="content-in-button">
									<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
 									<path stroke-linecap="round" stroke-linejoin="round" d="M19 11H5m14 0a2 2 0 012 2v6a2 2 0 01-2 2H5a2 2 0 01-2-2v-6a2 2 0 012-2m14 0V9a2 2 0 00-2-2M5 11V9a2 2 0 012-2m0 0V5a2 2 0 012-2h6a2 2 0 012 2v2M7 7h10"></path>
									</svg>
								</div>
								<span>
									Vídeos
								</span>							
							</div>
						</a>
					<hr>
					</li>
					<li>
						<button class="btn" onclick="drop()">
							<div style="font-size: 12px;">
								CONFIGURAÇÕES DO VÍDEO
							</div>
							<svg x-bind:class="$store.sidebar.groupIsCollapsed(label) || '-rotate-180'" class="svg-config-vid" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
  								<path stroke-linecap="round" stroke-linejoin="round" d="M19 9l-7 7-7-7"></path>
							</svg>
						</button>
						<ul class="ul-config-video">
							<li>
								<a>
									<div  class="btn">
										<div class="content-in-button">
											<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
										  	<path stroke-linecap="round" stroke-linejoin="round" d="M7 4v16M17 4v16M3 8h4m10 0h4M3 12h18M3 16h4m10 0h4M4 20h16a1 1 0 001-1V5a1 1 0 00-1-1H4a1 1 0 00-1 1v14a1 1 0 001 1z"></path>
											</svg>
										</div>
										<span>Categorias</span>
									</div>
								</a>
							</li>
							<li>
								<a>
									<div class="btn">
										<div class="content-in-button">
											<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
										  	<path stroke-linecap="round" stroke-linejoin="round" d="M19 20H5a2 2 0 01-2-2V6a2 2 0 012-2h10a2 2 0 012 2v1m2 13a2 2 0 01-2-2V7m2 13a2 2 0 002-2V9a2 2 0 00-2-2h-2m-4-3H9M7 16h6M7 8h6v4H7V8z"></path>
											</svg>
										</div>
										<span>Gêneros</span>
									</div>
								</a>
							</li>
							<li>
								<a>
									<div class="btn">
										<div class="content-in-button">
											<svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
										  	<path stroke-linecap="round" stroke-linejoin="round" d="M10 6H5a2 2 0 00-2 2v9a2 2 0 002 2h14a2 2 0 002-2V8a2 2 0 00-2-2h-5m-4 0V5a2 2 0 114 0v1m-4 0a2 2 0 104 0m-5 8a2 2 0 100-4 2 2 0 000 4zm0 0c1.306 0 2.417.835 2.83 2M9 14a3.001 3.001 0 00-2.83 2M15 11h3m-3 4h2"></path>
											</svg>
										</div>
										<span>Elenco</span>
									</div>
								</a>
								
							</li>
						</ul>
					</li>
				</ul>
			</nav>
		</div>
		<div class="content">
			<header class="header-top-bar">
				<div>
					<div class="photo" style="background-image: url('https://ui-avatars.com/api/?name=A&color=FFFFFF&background=111827');background-position: center;
    						background-size: cover;">
    				</div>
				</div>
			</header>
			<main>
				<div class="title-main">
					<h1>Vídeos</h1>
					<button>Criar Vídeo</button>
				</div>
				<div class="container-main">

				</div>
			</main>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/jq.js"></script>
	<script>
		function drop(){
			let btn = $('.conf')[0];
			let element = $('ul')[1];
					
			switch(element.className){		
				case "ul-config-video": {
					element.classList.remove("ul-config-video")
					element.classList.add("ul-config-video-act")
					break;
				}
				case "ul-config-video-act": {
					element.classList.remove("ul-config-video-act")
					element.classList.add("ul-config-video")
					break;
				}
			}
		}
	</script>
</body>
</html>