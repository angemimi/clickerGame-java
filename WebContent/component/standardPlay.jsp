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
			<p> <span class="trigger-click">0</span> par seconde</p>
			<div>
				<img src="img/rocher.png" class="roche"/>
			</div>
		</div>
		<div class="col col-md-6 col-sm-6 col-xs-12">
			<div class="row">
				<div class="disabled miners-div col-sm-6 col-md-6">
					<div class="filter"></div>
					<div class="img-bonus">
						<img src="img/miner.png" class="card-img-top add-miner img-bonus">
					</div>
					<div class="card-body">
						<p><span class="price-miner"><%= player.getPlayGame().getMiner().getPrice() %></span> <img src="img/piece.png" class="icon"></p>
						<p><span class="nb-miner"><%= player.getPlayGame().getMiner().getNumber() %></span> mineur(s)</p>
					</div>
				</div>
				
				<div class="disabled chariot-div col-sm-6 col-md-6">
					<div class="filter"></div>
					<div class="img-bonus">
						<img src="img/chariot.png" class="card-img-top add-chariot">
					</div>
					<div class="card-body">
						<p><span class="price-chariot"><%= player.getPlayGame().getChariot().getPrice() %></span> <img src="img/diams.png" class="icon"></p>
						<p><span class="nb-chariot"><%= player.getPlayGame().getChariot().getNumber() %></span> chariot(s)</p>
					</div>
				</div>
			</div>
		</div>
		<div class="col col-md-3 col-sm-3 col-xs-12">
			<div class="row">
				<div class="col col-sm-6 col-md-6 hidden-xs pieces-div disabled">
					<div class="filter"></div>
					<img src="img/pieces.png" class="card-img-top" />
					<div class="card-body">
					    <p><span class="pieces"><%= player.getPlayGame().getNbPiece() %></span></p>
					    <p>15 <img alt="pierre" src="img/rocher.png" class="icon roc">
					</div>					
				</div>
				<div class="col col-sm-6 col-md-6 hidden-xs diams-div disabled">
					<div class="filter"></div>
					<img src="img/diams.png" class="card-img-top" />
					<div class="card-body">
					    <p><span class="diams"><%= player.getPlayGame().getNbDiamond() %></span></p>
					    <p>50 <img alt="pierre" src="img/rocher.png" class="icon roc">
					</div>					
				</div>
			</div>
		</div>
	</div>
</section>