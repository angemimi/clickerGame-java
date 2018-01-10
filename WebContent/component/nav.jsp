<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.angemimi.classes.*, java.util.*"%>
<% 
	UUID uuid = (UUID)request.getAttribute("playerId");
	Player player = new Player();
	if(uuid != null){
		player = (Player)request.getSession().getAttribute("player"+uuid);
	}
	String pageName = (String)request.getAttribute("pageName");
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="home">Miner clicker</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	
	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item <%if(pageName=="home"){ %>active<%} %>">
				<a class="nav-link" href="home">Accueil</a><span class="sr-only">(current)</span>
			</li>
			<li class="nav-item <%if(pageName=="standardGame"){ %>active<%} %>">
				<a class="nav-link" href="standardGame">Partie Standard</a>
			</li>
		</ul>
		<ul class="navbar-nav mr-auto" id="rigthNav">
			<li class="nav-item">
				<a href="#" class="nav-link">
					<% if(player.getId() != null){%>
					<%= player.getName() %>
					<%} else { %>
						&nbsp;
					<%} %>
				</a>
			</li>
		</ul>
	</div>
</nav>