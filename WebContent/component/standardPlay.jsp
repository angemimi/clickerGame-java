<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.angemimi.classes.*, java.util.*"%>
<% 
	UUID uuid = (UUID)request.getAttribute("playerId");
	Player player = new Player();
	if(uuid != null) {
		player = (Player)request.getSession().getAttribute("player"+uuid);
	}
%>
<script src="js/views/standardPlay.js" type="text/javascript"></script>
<section class="content standardGame">
	<div class="row">
		<div class="col col-md-3 col-sm-3 col-xs-12">
			<p class="score"><%= player.getPlayGame().getScore() %></p>
			<img src="img/rocher1.jpeg" class="roche" />
			<p>Meilleur score : <%= player.getHigthScore() %></p>
		</div>
		<div class="col col-md-6 col-sm-6 col-xs-12">
			<div class="disabled">
			</div>
		</div>
		<div class="col col-md-3 col-sm-3 col-xs-12">
			<div>
				Bonus ?
			</div>
			<div>
				Mineur
			</div>
		</div>
	</div>
</section>