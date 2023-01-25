<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
    <container>
        <form>
        <input type="hidden" id="id" value="${board.id}"></input>
          <div class="form-group">
            <label for="title" class="form-label">제목:</label>
            <input value="${board.title}" type="title" class="form-control" id="title" placeholder="Enter title">
          </div>
          <div class="form-group">
              <label for="content">내용:</label>
              <textarea class="form-control summernote" rows="5" id="contents" name="text"></textarea>
          </div>
          <br/>
        </form>
      <button id="btn-update" class="btn btn-primary">수정 저장</button>

    </container>
    <br />

    <script src="/js/board.js"></script>
    <script>
      $(document).ready(function() {
              $('.summernote').summernote({
              height: 300,
              tabsize: 2});
              $(".summernote").summernote("code", `${board.contents}`);
          });
    </script>

<%@ include file="../layout/footer.jsp"%>
