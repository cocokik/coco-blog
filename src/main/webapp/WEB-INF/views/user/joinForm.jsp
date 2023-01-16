<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
    <container>
        <form>
          <div class="mb-3 mt-3">
            <label for="userName" class="form-label">이름:</label>
            <input type="userName" class="form-control" id="username" placeholder="Enter 이름" name="name">
          </div>
          <div class="mb-3">
            <label for="pwd" class="form-label">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
          </div>
          <div class="mb-3 mt-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
          </div>
        </form>
        <button id="btn_save" class="btn btn-primary">회원가입</button>

    </container>
    <br />
    <script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
