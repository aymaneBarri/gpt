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
	
	$(document).on('click', '.end-task', function() {
		console.log(this.value);
		$.ajax({
			type: 'POST',
			url: 'taches',
			data: { idTache: this.value, etatTache: 'Termine' },
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

	$(document).on('click', '.show-comments', function() {
		$.ajax({
			url: 'resources/commentaires/afficher',
			data: { idTache: this.value },
			error: function(result) {
				console.log('Something went wrong in show-comments. Handle errors here...');
			},
			success: function(result) {
				console.log('show-comments success ' + this.value);
				$("#comments").load("assets/components/commentairesBody.jsp");
			}
		});
	});
/*
	$(".show-comments").click(function() {
		console.log("sho-comments");
		$.ajax({
			url: 'resources/commentaires/afficher',
			data: { idTache: this.value },
			error: function(result) {
				console.log('Something went wrong in show-comments. Handle errors here...');
			},
			success: function(result) {
				console.log('show-comments success ' + this.value);
				$("#comments").load("assets/components/commentairesBody.jsp");
			}
		});

		$.post('commentaires', {idTache: this.value}, function(result){
				console.log(this.value);
				$("#comments").load("commentaires");
			});
	});
*/
	/*$("#add-comment-form").submit(function() {
		$.ajax({
			url: 'resources/commentaires/ajouter',
			data: { idTache: this.value },
			error: function(x, s, e) {
				console.log('Something went wrong in add-comment-form. Handle errors here...');
			},
			success: function(result) {
				console.log('add-comment-form success ' + this.value);
				$("#comments").load("assets/components/commentairesBody.jsp");
			}
		});

		$.post('commentaires', {idTache: this.value}, function(result){
				console.log(this.value);
				$("#comments").load("commentaires");
			});
	});*/
	
	$("#add-comment-form").submit(function() {
		console.log(1);
        var options = {
            /* target:"#divResult", */

            success: function(html) {
                $("#comments").replaceWith($('#assets/components/commentairesBody.jsp', $(html)));
            },

            url: "http://localhost:8080/gpt/resources/commentaires/ajouter"
        }

        $(this).ajaxSubmit(options);
        return false;
    });

	$("#priorite-header").click(function(){
		console.log('priorite-header clicked');
		$.getJSON( "resources/commentaires/afficher", function( data ) {
            // do something on success
            console.log(data);
        });
	});
	
	
	$("#titre-header").click(function(){
		console.log('titre-header clicked');
	});
	
	$("#delai-header").click(function(){
		console.log('delai-header clicked');
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
	
	$(document).on('click', '.setCurrentProjectId', function() {
					console.log(this.value);
					$('#currentProjectId').val(this.value);
				});
	
});



function expandTasksCard(cardId) {
	$("#" + cardId).removeClass("col-md");
}