<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"></:authentication>
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
    <title>Bootstrap Example</title>

  </head>
  <body class="p-3 m-0 border-0 bd-example">

    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="/blog">코코킥</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

          <c:choose>
            <c:when test="${empty principal}">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active" href="/auth/join">회원가입</a></li>
                <li class="nav-item"><a class="nav-link" href="/auth/login">로그인</a></li>
              </ul>
            </c:when>
            <c:otherwise>
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link active"  href="/board/form">글쓰기</a></li>
                <li class="nav-item"><a class="nav-link" href="/user/form">회원정보</a></li>
                <li class="nav-item"><a class="nav-link" href="/logout">로그아웃</a></li>
              </ul>
            </c:otherwise>
          </c:choose>


        </div>
      </div>
    </nav>
