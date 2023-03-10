let index = {
    init: function(){
        console.log("init");
        $("#btn-update").on("click",()=>{
            this.update();
        });
        $("#btn-delete").on("click",()=>{
            this.deleteById();
        });
        $("#btn-reply-save").on("click",()=>{
            this.replySave();
        });
        },
    deleteById: function(){
        var id = $("#id").attr("value")
        console.log(id)
         $.ajax({
            type: "DELETE",
            url: "/api/board/" + id,
            contentType: "application/json; char=utf-8", //body data type
            dataType: "json" //응답 데이터 타입 은 기본으로 문자열인데 json 으로 하고 스트링이 json 인 경우 자바스크립트 객체로 변경해줌
        }).done((res) => {
            if(res.data == 1){
                console.log(res);
                alert("삭제 완료");
                location.href="/";
            } else {
            alert("삭제 실패");
            }
        }).fail((error)=>{
            alert("삭제 실패.");
        })
    },
    update: function(){
        //ajax default = 비동기 호출
        $.ajax({
            type: "DELETE",
            url: "/api/board",
            data: JSON.stringify(data), //바디 데이터
            contentType: "application/json; char=utf-8", //body data type
            dataType: "json" //응답 데이터 타입 은 기본으로 문자열인데 json 으로 하고 스트링이 json 인 경우 자바스크립트 객체로 변경해줌
        }).done((res) => {
            if(res.data == 1){
                console.log(res);
                alert("삭제 완료");
                location.href="/";
            } else {
            alert("삭제 실패");
            }
        }).fail((error)=>{
            alert("삭제 실패.");
        })
    },
    replySave: function(){
        let data={
            content: $("#reply-content").val(),
            boardId: $("#board-id").val(),
            userId: $("#user-id").val()
        };
        console.log(data)
        //ajax default = 비동기 호출
        $.ajax({
            type: "POST",
            url: `/api/board/${data.boardId}/reply`,
            data: JSON.stringify(data), //바디 데이터
            contentType: "application/json; char=utf-8", //body data type
            dataType: "json" //응답 데이터 타입 은 기본으로 문자열인데 json 으로 하고 스트링이 json 인 경우 자바스크립트 객체로 변경해줌
        }).done((res) => {
            if(res.data == 1){
                console.log(res);
                alert("댓글 저장 완료");
                location.href=`/board/${data.boardId}`;
            } else {
            alert("댓글 저장 실패");
            }
        }).fail((error)=>{
            alert(JSON.stringify(error));
        })
    },
    replyDelete: function(boardId, replyId){
        $.ajax({
            type: "DELETE",
            url: `/api/board/${boardId}/reply/${replyId}`,
            contentType: "application/json; char=utf-8", //body data type
            dataType: "json" //응답 데이터 타입 은 기본으로 문자열인데 json 으로 하고 스트링이 json 인 경우 자바스크립트 객체로 변경해줌
        }).done((res) => {
            if(res.data == 1){
                console.log(res);
                alert("댓글 삭제 완료");
                location.href=`/board/${boardId}`;
            } else {
            alert("댓글 삭제 실패");
            }
        }).fail((error)=>{
            alert(JSON.stringify(error));
        })
    },
};
index.init();