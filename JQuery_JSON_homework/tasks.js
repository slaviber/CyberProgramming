 $(function() {
 	"use strict";

 	console.log($('#footer a.tu').attr("title"));
 	
 	console.log($('#home #col1 p').text());
 	
 	$('#header #menu-top-level-menu').append('<li> <a href = "#"> new button ');
 	
 	$('#footer').prepend('<div id="dynamiccontent">');
 	
 	$('#footer #dynamiccontent').append('<input id="textinput">');
 
 });