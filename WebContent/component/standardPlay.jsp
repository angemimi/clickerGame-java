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
<section class="container standardGame">
	<div class="row">
		<div class="col col-md-3 col-sm-3 col-xs-12">
			<input type="hidden" value="<%= player.getId() %>" name="idPlayer">
			<p class="score"><%= player.getPlayGame().getScore() %></p>
			<img src="img/rocher.png" class="roche" />
		</div>
		<div class="col col-md-6 col-sm-6 col-xs-12">
			<div class="disabled">
			</div>
		</div>
		<div class="col col-md-3 col-sm-3 col-xs-12">
			<div class="row">
				<div class="col col-sm-4 col-md-4 hidden-xs card">
					<img src="img/pieces.png" class="icon card-img-top" />
					<div class="card-body">
					    <span class="pieces"><%= player.getPlayGame().getNbPiece() %></span>
					</div>					
				</div>
				<div class="col col-sm-4 col-md-4 hidden-xs card">
					<img src="img/diams.png" class="icon card-img-top" />
					<div class="card-body">
					    <span class="diams"><%= player.getPlayGame().getNbDiamond() %></span>
					</div>					
				</div>
			</div>
			<div>
				Mineur
			</div>
		</div>
	</div>
</section>