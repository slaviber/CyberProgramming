 $(function() {
 	"use strict";

 	console.log($('#footer a.tu').attr("title"));
 	
 	console.log($('#home #col1 p').text());
 	
 	$('#header #menu-top-level-menu').append('<li id="menu-item-0000"> <a href = "#"> new button ');
 	
 	$('#footer').prepend('<div id="dynamiccontent">');
 	
 	$('#footer #dynamiccontent').append('<input id="textinput">');
 	
 	$('#footer #dynamiccontent').append('<button id="addbutton"> click ');
 	
 	$('#footer #dynamiccontent').append('<ul id="posts">');
 	
 	$( "#header #menu-top-level-menu #menu-item-0000" ).click(function() {
 		$("#home .inscreen div:nth-child(2)").after($("#home .inscreen div:nth-child(1)"));
 	 });
 	
 	$.ajax("http://jsonplaceholder.typicode.com/posts/", { method: "GET" }).then(function(data) {
 		for(var i = 0; i < 5; i++){
 			$("#posts").append($('<li/>').text(data[i].body));
 		}
 	});
 	
 	function listing(datum){
		$('#posts').append($('<li/>').text(datum.body).append($('<button/>').text("X").click(function(){
				if(confirm("Deleting "+datum.body+"!")){
					$.ajax("http://jsonplaceholder.typicode.com/posts/"+datum.id, { method: "DELETE" }).then(function() {
						$("#posts li:contains("+datum.body+")").remove();
					});
				}
		})));
 	}
 	
 	$("#footer #dynamiccontent #addbutton").click(function() {
 		if(!($("#footer #dynamiccontent #textinput").val().trim())){
 			alert("you must enter text");
 		}
 		else {
 			$.ajax("http://jsonplaceholder.typicode.com/posts/", { 
 				method: 'POST', 
 				data: { userId: 10, 
 				title: "posting", 
 				body:$("#footer #dynamiccontent #textinput").val()
 			}}).then(function(data) {
 				$.ajax("http://jsonplaceholder.typicode.com/posts/"+data.id, { method: "GET" }).then(function(data) {listing(data);});
 			});
 		}
 	});
 	
 	$('#footer #dynamiccontent #posts').before($("<input/>").change(function(){
 		$.ajax("http://jsonplaceholder.typicode.com/posts?userId="+$(this).val(), { method: "GET" } ).then(function(data){
			$('#posts').empty();
 			$.each(data, function() {listing(this);});
 		});
 	}));

 });