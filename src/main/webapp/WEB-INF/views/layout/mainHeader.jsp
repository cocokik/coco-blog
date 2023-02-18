<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://getbootstrap.com/docs/5.3/assets/css/docs.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>

    <link rel="shortcut icon" href="/image/favicon.ico" type="image/x-icon">
    <link rel="icon" href="/image/favicon.ico" type="image/x-icon">
    <link href="/css/coco.css" rel="stylesheet">
    <link href="/css/mainscroll.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <style>
        @import url('https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap');
    </style>

    <!-- include summernote css/js-->
      <!-- <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
      <script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script> -->

    <title>COCOKIK</title>

  </head>
  <body>
    <nav class ="menu">
        <c:choose>
          <c:when test="${empty principal}">
            <ul>
              <li><a href = "/"><b>Home</b></a></li>
              <li><a href = "/user/aboutForm"><b>about</b></a></li>
              <li><a href = "/auth/joinForm"><b>Join</b></a></li>
              <li><a href = "/auth/loginForm"><b>Login</b></a></li>
            </ul>
          </c:when>
          <c:otherwise>
            <ul>
              <li><a href = "/"><b>Home</b></a></li>
              <li><a href = "/user/aboutForm"><b>about</b></a></li>
              <li><a href = "/board/saveForm"><b>Write</b></a></li>
              <li><a href = "/user/updateForm"><b>Profile</b></a></li>
              <li><a href = "/logout"><b>Logout</b></a></li>
            </ul>
          </c:otherwise>
        </c:choose>
    </nav>