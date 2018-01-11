var scoreForPiece = 0;
var scoreForDiams = 0;
$(document).off('click', '.standardGame .roche').on('click', '.standardGame .roche', function(e){
	var score = $(document).find('.standardGame .score');
	var score_int = parseInt(score.text());
	var piece = $(document).find('.standardGame .pieces');
	score_int+=1;
	scoreForPiece = (scoreForPiece < 100 ? scoreForPiece +1 : 0);
	scoreForDiams = (scoreForDiams < 100 ? scoreForDiams +1 : 0);;
	// Proposition d'acheter une pièce
	if(scoreForPiece == 100){
		bootbox.confirm({
			title: "Une pièce",
			message: "Pour 100 pierres vous pouvez avoir une pèce. La voulez vous ?",
			buttons: {
				confirm:{
					label:"Oui"
				},
				cancel:{
					label:'Non'
				}
			},
			callback: function(result){
				scoreForPiece = 0;
				if(result){
					piece.text(parseInt(piece.text()) + 1);
					score_int = score_int-100;
					score.text(score_int);
				}
			}
		});
		
		// Proposition d'acheter un diamand
		if(scoreForDiams == 500){
			bootbox.confirm({
				title: "Un diamand",
				message: "Pour 500 pierre vous pouvez avoir un diamand. ",
				buttons: {
					confirm:{
						label:"Oui"
					},
					cancel:{
						label:'Non'
					}
				},
				callback: function(result){
					scoreForDiams = 0;
					if(result){
						piece.text(parseInt(piece.text()) + 1);
						score_int = score_int-500;
						score.text(score_int);
					}
				}
			});
		}
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
//	    alert( "complete" );
	  });
});