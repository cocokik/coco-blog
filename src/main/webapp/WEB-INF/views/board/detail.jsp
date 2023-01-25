<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
    <container>
    <br/>
        <button class="btn btn-secondary" onClick="history.back()">돌아가기</button>
        <c:if test= "${board.user.userName == principal.user.userName}">
            <a href="/board/${board.id}/updateForm" class="btn btn-warning">수정</a>
            <button id="btn-delete" class="btn btn-danger">삭제</button>
        </c:if>
        <br/>
        <div>
        글번호 : <span id="id" value="${board.id}"><i>${board.id}</i></span>
        작성자 : <span id="username"><i>${board.user.userName}</i></span>
        </div>

          <hr />
          <div class="form-group">
            <label for="title" class="form-label">제목:</label>
            <h3>${board.title}</h3>
          </div>
          <hr />
          <div class="form-group">
              <label for="content">내용:</label>
              <div>${board.contents}</div>
          </div>
          <br/>
          <hr />

    </container>
    <br />
<script src="/js/detail.js"></script>
<%@ include file="../layout/footer.jsp"%>
