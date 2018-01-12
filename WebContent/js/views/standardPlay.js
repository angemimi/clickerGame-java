$(document).off('click', '.standardGame .roche').on('click', '.standardGame .roche', function(e){
	var score = $(document).find('.standardGame .score');
	var score_int = parseInt(score.text());
	var piece = $(document).find('.standardGame .pieces');
	score_int+=1;
	// Proposition d'acheter une pièce
	if(score_int >= 15){
		$(document).find('.standardGame .pieces-div').removeClass('disabled');
	}
		
	// Proposition d'acheter un diamand
	if(score_int >= 50){
		$(document).find('.standardGame .diams-div').removeClass('disabled');
	}
	
	// Envoie de la modification au serveur
	$.ajax("saveGame?score="+score_int+"&diams=0&pieces="+piece.text()+"&idPlayer="+$(document).find('.standardGame [name="idPlayer"]').val())
	.done(function() {
		score.text(score_int);
	  })
	  .fail(function(xhr) {
	    alert( "error " + xhr.responseText);
	  })
	  .always(function() {
//		    alert( "complete" );
	  });
});

// click pour avoir une piece
$(document).off('click','.standardGame .pieces-div').on('click','.standardGame .pieces-div', function(e){
	var piece = $(document).find('.standardGame .pieces');
	var score = $(document).find('.standardGame .score');

	var score_int = parseInt(score.text());
	if(!$(document).find('.standardGame .pieces-div').hasClass('disabled')){
		if(score_int >= 15) {
			piece.text(parseInt(piece.text()) + 1);
			score_int = score_int-15;
			score.text(score_int);
			if(score_int < 15){
				$(document).find('.standardGame .pieces-div').addClass('disabled');
			}
		}
	}
	if(!$(document).find('.standardGame .diams-div').hasClass('disabled') && score_int < 50){
		$(document).find('.standardGame .diams-div').addClass('disabled');
	}
	
	if(parseInt(piece.text()) >= parseInt($(document).find('.standardGame .miners-div .price-miner').text())){
		$(document).find('.standardGame .miners-div').removeClass('disabled');
	}
});

// Acherter un diamand
$(document).off('click','.standardGame .diams-div').on('click','.standardGame .diams-div', function(e){
	var diams = $(document).find('.standardGame .diams');
	var score = $(document).find('.standardGame .score');
	var score_int = parseInt(score.text());
	if(!$(document).find('.standardGame .diams-div').hasClass('disabled')){
		if(score_int >= 50) {
			diams.text(parseInt(diams.text()) + 1);
			score_int = score_int-50;
			score.text(score_int);
			if(score_int < 50){
				$(document).find('.standardGame .diams-div').addClass('disabled');
			}
		}
	}
	if(!$(document).find('.standardGame .pieces-div').hasClass('disabled') && score_int < 15){
		$(document).find('.standardGame .pieces-div').addClass('disabled');
	}
	
	if(parseInt(diams.text()) >= parseInt($(document).find('.standardGame .chariot-div .price-chariot').text())){
		$(document).find('.standardGame .chariot-div').removeClass('disabled');
	}
});

$(document).off('click','.standardGame .miners-div .add-miner').on('click','.standardGame .miners-div .add-miner', function(){
	var piece = $(document).find('.standardGame .pieces');
	var piece_int = parseInt(piece.text());
	var price = $(document).find('.standardGame .miners-div .price-miner');
	var price_miner = parseInt(price.text());
	var nb = $(document).find('.standardGame .miners-div .nb-miner');
	var nb_miner = parseInt(nb.text());
	var trigger_click = $(document).find('.standardGame .trigger-click');
	var trigger_click_int = parseInt(trigger_click.text());
	
	if(!$(document).find('.standardGame .miners-div').hasClass('disabled')){
		if(piece_int >= price_miner){
			nb_miner += 1;
			nb.text(nb_miner);
			piece_int = piece_int - price_miner;
			piece.text(piece_int);
			
			price_miner += 5;
			price.text(price_miner);
			trigger_click_int += 1;
			trigger_click.text(trigger_click_int);
			
			if(piece_int < price_miner){
				$(document).find('.standardGame .miners-div').addClass('disabled');
			}
		}
	}
});

$(document).off('click','.standardGame .chariot-div .add-chariot').on('click','.standardGame .chariot-div .add-chariot', function(){
	var diams = $(document).find('.standardGame .diams');
	var diams_int = parseInt(diams.text());
	var price = $(document).find('.standardGame .chariot-div .price-chariot');
	var price_chariot = parseInt(price.text());
	var nb = $(document).find('.standardGame .chariot-div .nb-chariot');
	var nb_miner = parseInt(nb.text());
	var trigger_click = $(document).find('.standardGame .trigger-click');
	var trigger_click_int = parseInt(trigger_click.text());
	
	if(!$(document).find('.standardGame .chariot-div').hasClass('disabled')){
		if(diams_int >= price_chariot){
			nb_miner += 1;
			nb.text(nb_miner);
			diams_int = diams_int - price_chariot;
			diams.text(diams_int);
			
			price_chariot += 5;
			price.text(price_chariot);
			trigger_click_int += 5;
			trigger_click.text(trigger_click_int);
			
			if(diams_int < price_chariot){
				$(document).find('.standardGame .chariot-div').addClass('disabled');
			}
		}
	}
});

$(document).ready(function(){
	setInterval(function(){
		var miner = $(document).find('.standardGame .miners-div .nb-miner');
		var nb_miner = parseInt(miner.text());
		var chariot = $(document).find('.standardGame .chariot-div .nb-chariot');
		var nb_chariot = parseInt(chariot.text());
		var score = $(document).find('.standardGame .score');
		var score_int = parseInt(score.text());
		
		// ajout d'un click par seconde pour les mineur
		if(nb_miner > 0){
			score_int += nb_miner;
			score.text(score_int-1);
			$(document).find('.standardGame .roche').trigger('click');
		}
		
		if(nb_chariot > 0){
			score_int += (nb_chariot*5);
			score.text(score_int-1);
			$(document).find('.standardGame .roche').trigger('click');
		}
	},1000);
});