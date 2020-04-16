<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Community-Markat</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="assets/css/main.css" />
		 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
	</head>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script> 
	<script>
	$(document).ready(function(){
		var id = "${session_id}";
		if(id != '' && id != null){
			$.ajax({
				type : "post",
				url : "LoginMenu",
				data : {"user_id" : id},
				success : function(data){
					$("#LoginMenu").html(data);
				}
			})
		}else{
			$.ajax({
				type : "get",
				url : "LoginMenu",
				success : function(data){
					$("#LoginMenu").html(data);
				}
			})
		}
	})
	</script>
	<body>

		<!-- Wrapper -->
<div id="wrapper">
	<div id="main">
		<div class="inner">
			<div id="LoginMenu"></div>