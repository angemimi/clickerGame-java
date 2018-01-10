$(document).off('click', '.home .standardPlay').on('click', '.home .standardPlay', function(e){
	e.preventDefault();
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
	})
});