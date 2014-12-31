 $(function() {
 	"use strict";

 	console.log($('#footer a.tu').attr("title"));
 	
 	console.log($('#home #col1 p').text());
 	
 	$('#header #menu-top-level-menu').append('<li id="menu-item-0000"> <a href = "#"> new button ');
 	
 	$('#footer').prepend('<div id="dynamiccontent">');
 	
 	$('#footer #dynamiccontent').append('<input id="textinput">');
 	
 	$('#footer #dynamiccontent').append('<button id="addbutton"> click ');
 	
 	$('#footer #dynamiccontent').append('<ul id="posts">');
 	
 	$( "#header #menu-top-level-menu #menu-item-0000" ).click(function() {alert("hello world");});
 
 });