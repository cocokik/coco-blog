<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/header.jsp"%>
    <container>
        <form>
        <input type="hidden" value="${principal.user.id}" id="id"/>
          <div class="mb-3 mt-3">
            <label for="userName" class="form-label">이름:</label>
            <input type="userName" class="form-control" id="username" value="${principal.user.userName}" name="name" readOnly>
          </div>

          <c:if test="${empty principal.user.oauth}">
              <div class="mb-3">
                <label for="pwd" class="form-label">Password:</label>
                <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
              </div>
          </c:if>
          <div class="mb-3 mt-3">
            <label for="email" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email"  value="${principal.user.email}">
          </div>
        </form>
        <button id="btn_update" class="btn btn-primary">회원수정</button>

    </container>
    <br />
    <script src="/js/user.js"></script>
<%@ include file="../layout/footer.jsp"%>
