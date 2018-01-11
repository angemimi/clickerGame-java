<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.angemimi.classes.*, java.util.*"%>
<%
	UUID uuid = (UUID)request.getAttribute("playerId");
	Player player = new Player();
	if(uuid != null){
		player = (Player)request.getSession().getAttribute("player"+uuid);
	}
%>
<script type="text/javascript" src="js/views/home.js"></script>
<!-- <script type="text/javascript" src="js/util/jquery.js"></script> -->
<section class="container home">
	<input type="hidden" value="<%=player.getId() %>" name="playerId">
	<h1>Miner clicker</h1>
	<p>Trouver des joyaux ou de l'or. Mais pour cela il faut casser des cailloux</p>
	<a href="standardGame" type="button" class="btn btn-primary standardPlay" title="Jouer à une partie standard">Jouer !</a>
</section>