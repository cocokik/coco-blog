<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
    <container>
        <form action="/auth/loginProc" method="post">
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
          <button type="submit" id="btn_login" class="btn btn-primary">로그인</button>
          <a href="https://kauth.kakao.com/oauth/authorize?client_id=4bbc99f4047d689792b910febf22f9a6&redirect_uri=http://localhost/auth/kakao/callback&response_type=code">
          <img height="39px" src="/image/kakao_login_button.png"/></a>
        </form>

    </container>
    <br />
    <script src="/js/user.js"></script>

<%@ include file="../layout/footer.jsp"%>

