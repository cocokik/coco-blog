<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
    <container>
        <form action="#" method="post">
          <div class="mb-3 mt-3">
            <label for="userName" class="form-label">이름:</label>
            <input type="userName" class="form-control" id="username" placeholder="Enter 이름" name="username">
          </div>
          <div class="mb-3">
            <label for="pwd" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
          </div>
          <div class="form-check mb-3">
            <label class="form-check-label">
              <input class="form-check-input" type="checkbox" name="remember"> Remember me
            </label>
          </div>
          <button id="btn_login" class="btn btn-primary">로그인</button>
        </form>

    </container>
    <br />
    <script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>
