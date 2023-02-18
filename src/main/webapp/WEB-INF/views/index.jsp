<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="layout/mainHeader.jsp"%>

<div id="container">
    <c:forEach var="board" items="${boards.content}">
        <div class="list">
            <div class="one">  
                <h3><strong>${board.title}</strong></h3><br>
                <div class="index-content">${board.contents}</div>
                <a href="/board/${board.id}" class="btn btn-secondery">Click or scroll</a>
            </div>
        </div>
    </c:forEach>
    <br />

    <!-- <ul class="pagination justify-content-center">
        <c:choose>
            <c:when test="${boards.first}">
                <li class="page-item disabled"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
            </c:when>
            <c:otherwise>
                <li class="page-item"><a class="page-link" href="?page=${boards.number-1}">Previous</a></li>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${boards.last}">
                    <li class="page-item disabled"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:when>
            <c:otherwise>
                    <li class="page-item"><a class="page-link" href="?page=${boards.number+1}">Next</a></li>
            </c:otherwise>
        </c:choose>
    </ul> -->
    <div class="mt-5 p-4 bg-dark text-white text-center">
        <p>Created by Cocokik</p>
        <p>❤️</p>
    </div>
</div>

<script type="text/javascript" src="/js/scrollmove.js"></script>
    
</body>
