$(document).ready(function() {
	$("#expand-todo-button").click(function() {
		expandTasksCard("todo-card")
	});
	/* document.getElementById("expand-doing-button").onclick = function() {
		expandTasksCard("doing-card")
	};
	document.getElementById("expand-done-button").onclick = function() {
		expandTasksCard("done-card")
	}; */

	$(document).on('click', '.start-task', function() {
		console.log(this.value);
		$.ajax({
			type: 'POST',
			url: 'taches',
			data: { idTache: this.value, etatTache: 'EnCours' },
			error: function(result) {
				console.log("error in starting task");
			},
			success: function(result) {
				$("#tasks").load("taches")
			}
		}).then(function() {
			$("#tasks").load("taches")
		});
	});

	/*$(".start-task").click(function() {
		console.log(this.value);
		$.ajax({
			type: 'POST',
			url: 'taches',
			data: { idTache: this.value, etatTache: 'EnCours' },
			error: function(result){
				console.log("error in starting task");
			},
			success: function(result) {
				$("#tasks").load("taches")
			}
		}).then(function(){
			$("#tasks").load("taches")
		});
	});*/

	/*$(".show-comments").click(function() {
		console.log(this.value);
		$("#test").load(
			"commentaires" 
			
		);
		$.ajax({
			type: 'GET',
			url: 'commentaires',
			data: { idTache: this.value },
			success: function(result) {
				console.log('show-comments success '+this.value);
				$("#comments").load("commentaires");
			}
		});

		$.post('commentaires', {idTache: this.value}, function(result){
				console.log(this.value);
				$("#comments").load("commentaires");
			});
	});
	
	$("#add-comment-form").submit(function() {
		console.log(this.value);
		$("#test").load(
			"commentaires" 
			
		);
		$.ajax({
			type: 'POST',
			url: 'commentaires',
			data: { idTache: this.value },
			success: function(result) {
				console.log('show-comments555 success '+this.value);
				$("#comments").load("commentaires");
			}
		}).done(function(){
			console.log('show-comments555 success '+this.value);
				$("#comments").load("commentaires");
		});

		$.post('commentaires', {idTache: this.value}, function(result){
				console.log(this.value);
				$("#comments").load("commentaires");
			});
	});*/

	$(".show-comments").click(function() {
		console.log(this.value);
		/*$("#test").load(
			"commentaires" 
			
		);*/
		/*$.ajax({
			type: 'GET',
			url: 'api/commentaires/afficher',
			data: { idTache: this.value },
			success: function(result) {
				console.log('show-comments success '+this.value);
				$("#comments").load("api/commentaires/afficher");
			}
		});*/

		$.ajax({
			url: 'api/commentaires/afficher',
			data: { idTache: this.value },
			error: function(x, s, e) {
				console.log('Something went wrong. Handle errors here...');
			},
		}).then(function() {
			console.log('show-comments success ' + this.value);
			$("#comments").load("commentaires");
		});

		/*$.post('commentaires', {idTache: this.value}, function(result){
				console.log(this.value);
				$("#comments").load("commentaires");
			});*/
	});

	$(".add-comment-form").submit(function() {
		console.log(this.value);
		/*$("#test").load(
			"commentaires" 
			
		);*/
		$.ajax({
			url: 'api/commentaires/ajouter',
			data: { idTache: this.value },
			error: function(x, s, e) {
				console.log('Something went wrong. Handle errors here...');
			},
			success: function(result) {
				console.log('show-comments555 success ' + this.value);
				$("#comments").load("commentaires");
			}
		}).then(function() {
			console.log('show-comments555 success ' + this.value);
			$("#comments").load("commentaires");
		});

		/*$.post('commentaires', {idTache: this.value}, function(result){
				console.log(this.value);
				$("#comments").load("commentaires");
			});*/
	});
	
	/*$(document).on('submit', '#add-comment-form', function() {
		console.log(this.value);
		$("#test").load(
			"commentaires" 
			
		);
		$.ajax({
			url: 'api/commentaires/ajouter',
			data: { idTache: this.value },
			error: function(x, s, e) {
				console.log('Something went wrong. Handle errors here...');
			},
			success: function(result) {
				console.log('show-comments555 success ' + this.value);
				$("#comments").load("commentaires");
			}
		}).then(function() {
			console.log('show-comments555 success ' + this.value);
			$("#comments").load("commentaires");
		});
	});*/
});

function expandTasksCard(cardId) {
	$("#" + cardId).removeClass("col-md");
}