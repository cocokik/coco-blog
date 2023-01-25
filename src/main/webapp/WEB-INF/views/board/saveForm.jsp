<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
    <container>
        <form>
          <div class="form-group">
            <label for="title" class="form-label">제목:</label>
            <input type="title" class="form-control" id="title" placeholder="Enter title">
          </div>
          <div class="form-group">
              <label for="content">내용:</label>
              <textarea class="form-control summernote" rows="5" id="contents" name="text"></textarea>
          </div>
          <br/>
        </form>
      <button id="btn_board_save" class="btn btn-primary">저장</button>

    </container>
    <br />

    <script src="/js/board.js"></script>
    <script>
      $(document).ready(()=> {
              $('.summernote').summernote({
              height: 300,
              tabsize: 2});
          });
    </script>

<%@ include file="../layout/footer.jsp"%>
