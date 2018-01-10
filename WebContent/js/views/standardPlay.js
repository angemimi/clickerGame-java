$(document).off('click', '.standardGame .roche').on('click', '.standardGame .roche', function(e){
	var score = $(document).find('.standardGame .score');
	score.text(parseInt(score.text())+1);
	
});