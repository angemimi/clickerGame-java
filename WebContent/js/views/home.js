$(document).off('click', '.home .standardPlay').on('click', '.home .standardPlay', function(e){
	e.preventDefault();
	var id = $(document).find('.home [name="playerId"]').val();
	if(id == null || id == 'null'){
		bootbox.prompt({
			title:"Votre nom ?",
			buttons:{
				confirm:{
					label:"Ok"
				},
				cancel:{label:"Annuler"}
			},
			callback: function(result) {
				if(result) {
					$(location).attr('href', $(e.target).attr('href')+'?name='+result);
				}
			}
		});
	} else {
		$(location).attr('href', $(e.target).attr('href')+'?playerId='+id);
	}
});