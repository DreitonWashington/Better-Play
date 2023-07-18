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
							<svg x-bind:class="$store.sidebar.groupIsCollapsed(label) || '-rotate-180'" class="svg-config-vid rot" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke-width="2" stroke="currentColor" aria-hidden="true">
  								<path stroke-linecap="round" stroke-linejoin="round" d="M19 9l-7 7-7-7"></path>
							</svg>
						</button>
						<ul class="ul-config-video-act">
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
					<h1>Criar Video</h1>
				</div>
				<div class="container-main">
					<form enctype="multipart/form-data" action="${pageContext.request.contextPath}/adm/newVideo" method="POST" id="form">
						<input type="hidden" name="act" id="act" value=""/>
						<div class="content-video">
							<h2>Informações do vídeo</h2>
							<div class="container-form">
								<div class="group-input">
									<label for="title">Título</label>
									<input type="text" name="title" id="title"/>
								</div>
								<div class="group-input">
									<label for="slug">Slug</label>
									<input type="text" name="slug" id="slug"/>
								</div>
								<div class="group-textarea">
									<label for="descricao">Descrição</label>
									<textarea  rows="6" cols="50" name="descricao" id="descricao"></textarea>
								</div>
								<div class="group-input n">
									<label for="anoLancamento">Ano de Lançamento</label>
									<input type="number" name="anoLancamento" id="anoLancamento"/>
								</div>
								<div class="group-input n" style="margin-left: 19px;">
									<label for="duracao">Duração</label>
									<input type="number" name="duracao" id="duracao"/>
								</div>
								<div class="group-input n select">
									<label for="censura">Censura</label>
									<select name="censura" id="censura">
									 	<option value="" selected disabled hidden>Selecione uma opção</option>
										<option value="l">L</option>
										<option value="censura10">Censura 10</option>
										<option value="censura12">Censura 12</option>
										<option value="censura14">Censura 14</option>
										<option value="censura16">Censura 16</option>
										<option value="censura18">Censura 18</option>
									</select>
								</div>
								<div class="group-input n select" style="margin-left: 19px;">
									<label for="categoria">Categoria</label>
									<select name="categoria" id="categoria" onclick="searchCategory()">
									
									</select>
								</div>
								<div class="group-input n search select">
									<label for="genero">Gênero</label>
									<div class="only-input-search div-op-genre" onclick="dropGenre()" >
										<select name="genero" id="genero" hidden class="classinput-search"></select>
										<div class="choicesList"></div>
<!-- 										<input type="search" name="search" id="searchInp" placeholder="Selecione uma opção"  -->
<!-- 											onclick="dropGenre()" autocomplete="off"/> -->
									Selecione uma opção
									</div>
										<div class="select-choise-list">
											<div class="choise-list">
																				
											</div>
										</div>
								</div>
								<div class="group-input n search" style="margin-left: 19px;">
									<label for="elenco">Elenco</label>
									<input type="search" name="elenco" id="elenco" class="classinput-search" disabled="disabled"/>
								</div>
							</div>			
						</div>
						
						<div class="content-img">
							<fieldset>
								<legend>Imagem</legend>
								
								<div class="divInputFile">
									<h3 class="inputFileTitle">Banner</h3>
									<label for="banner" class="inputFile">Arraste o arquivo ou Clique aqui</label>
									<input type="file" id="banner"/>
								</div>
								
								<div class="divInputFile">
									<h3 class="inputFileTitle">Thumb</h3>
									<label for="thumb" class="inputFile">Arraste o arquivo ou Clique aqui</label>
									<input type="file" id="thumb"/>
								</div>
								
								<div class="divInputFile">
									<h3 class="inputFileTitle">Half Thumb</h3>
									<label for="halfthumb" class="inputFile">Arraste o arquivo ou Clique aqui</label>
									<input type="file" id="halfthumb"/>
								</div>
							</fieldset>						
						</div>
						<div class="content-vid">
							<fieldset>
								<legend>Vídeo</legend>
								
								<div class="divInputFile">
									<h3 class="inputFileTitle">Media</h3>
									<label for="media" class="inputFile">Arraste o arquivo ou Clique aqui</label>
									<input type="file" id="media"/>
								</div>
							</fieldset>
						</div>
						<div class="btn-list">
							<button class="btn-vid btn-primary">Criar</button>
							<button class="btn-vid">Criar e criar novo</button>
							<button class="btn-vid">Cancelar</button>
						</div>
					</form>
				</div>
			</main>
		</div>
	</div>
	<script src="${pageContext.request.contextPath}/jq.js"></script>
	<script>
	
	$("#btnsend").click(testVideo);

	function testVideo() {
	    var urlAction = $('#form2')[0].action;
	    var form = new FormData();
	    var file = $('#file')[0].files[0];
	    form.append('file', file);
	    
	    $.ajax({
	        method: "POST",
	        url: urlAction,
	        data: form,
	        contentType: false,
	        processData: false,
	        success: function(data) {
	            console.log(data);
	        }
	    });
	}
	
	function dropGenre() {
	    var element = document.querySelector('.choise-list');
	    var element2 = document.querySelector('.only-input-search');
	    var elements = document.getElementsByClassName('choise-option');

	    searchGenre();

	    if (element.classList.contains("not-hidden")) {
	        element.classList.remove("not-hidden");
	        element2.classList.remove("borderFieldSpecial")
	    } else {
	        element.classList.add("not-hidden");
	        element2.classList.add("borderFieldSpecial")
	    }

	    document.addEventListener("click", function (event) {
	        let isTargetMatched = event.target === element2 || event.target === element;
	        for (let i = 0; i < elements.length; i++) {
	            isTargetMatched = isTargetMatched || event.target === elements[i];
	        }
	        if (!isTargetMatched) {
	            element.classList.remove("not-hidden");
	            element2.classList.remove("borderFieldSpecial")
	        }
	    });
	}

	function searchGenre() {
	    var urlAction = document.getElementsByTagName('form')[0].action;

	    $.ajax({
	        method: "get",
	        url: urlAction,
	        data: "&act=searchGenre",
	        success: function (response) {
	            var json = JSON.parse(response);
	            var dropList = $('.choise-list');
	            dropList.empty();

	            for (let i = 0; i < json.length; i++) {
	                var option = $("<div class='choise-option'></div>").text(json[i].name).attr("id", json[i].id);
	                dropList.append(option);
	            }

	            $(".choise-option").click(function ($event) {
	                addGenreToList($event);
	            });
	        }
	    }).fail(function () {
	        alert("Erro");
	    });
	}

	function addGenreToList($event) {
	    var element = $("#genero");
	    var elementChildren = $("#genero")[0].children;
	    var elementInFocus = event.target;
	    var isValuePresent = false;
	    var choicesList = $(".choicesList")[0];
	    var divopgenre = $(".div-op-genre")[0];

	    for (let i = 0; i < elementChildren.length; i++) {
	        if (elementInFocus.id === elementChildren[i].value) {
	            isValuePresent = true;
	            break;
	        }
	    }

	    if (!isValuePresent) {
	        element.append("<option value=" + event.target.id + ">" + event.target.innerText + "</option>");
	        renderList($event.target);
	    }

	    if (choicesList.children.length > 0) {
	        divopgenre.classList.add("tbt");
	    }
	}

	function renderList(eventTarget) {
	    var element = $('.choicesList');
	    var eventId = eventTarget.id;
	    element.append("<div class='chosen' id=" + eventId + ">" + eventTarget.innerText + "<div class='btn-remove' onclick='removeGenreRenderList(" + eventId + ")'></div></div>");
	}

	function removeGenreRenderList(eventId) {
	    var element = $('.choicesList');
	    var optionToRemove = element.find("#" + eventId);
	    optionToRemove.remove();

	    var selectElement = $("#genero");
	    var optionToRemoveFromSelect = selectElement.find("option[value='" + eventId + "']");
	    optionToRemoveFromSelect.remove();

	    var divopgenre = $(".div-op-genre")[0];
	    if (element.children().length === 0) {
	        divopgenre.classList.remove("tbt");
	    }
	}
	
	function searchCategory(){
		var urlAction = document.getElementsByTagName('form')[0].action;
		
		$.ajax({
			method: "get",
			url: urlAction,
			data: "&act=searchCategory",
			success: function(response){
				var json = JSON.parse(response);
				var categorySelect = $('#categoria')
				if(categorySelect[0].children.length === 0){
					for(let i = 0 ; i < json.length ; i++)
						categorySelect.append("<option value="+json[i].id+">"+json[i].name+"</option>")					
				}
			}
		})
	}

		
	</script>
</body>
</html>