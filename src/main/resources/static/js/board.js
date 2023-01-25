let index = {
    init: function(){
            $("#btn_board_save").on("click",()=>{
                console.log(this)
                this.save();
            });

            $("#btn-update").on("click",()=>{
                console.log(this)
                this.update();
            });
    },
     save: function(){
         let data={
             title: $("#title").val(),
             contents: $("#contents").val(),};
         console.log(data);
         //ajax default = 비동기 호출
         $.ajax({
             type: "POST",
             url: "/api/board",
             data: JSON.stringify(data), //바디 데이터
             contentType: "application/json; char=utf-8", //body data type
             dataType: "json" //응답 데이터 타입 은 기본으로 문자열인데 json 으로 하고 스트링이 json 인 경우 자바스크립트 객체로 변경해줌
         }).done((res) => {
             if(res.data == 1){
                 console.log(res);
                 alert("저장 완료");
                 alert(JSON.stringify(res));
                 location.href="/";
             } else {
             alert("저장 실패");
             }
         }).fail((error)=>{
             alert(JSON.stringify(error));
         })
     },
     update: function(){
         let id= $("#id").attr("value");
         let data={
             title: $("#title").val(),
             contents: $("#contents").val(),};
         console.log(data);
         //ajax default = 비동기 호출
         $.ajax({
             type: "PUT",
             url: "/api/board/"+id,
             data: JSON.stringify(data), //바디 데이터
             contentType: "application/json; char=utf-8", //body data type
             dataType: "json" //응답 데이터 타입 은 기본으로 문자열인데 json 으로 하고 스트링이 json 인 경우 자바스크립트 객체로 변경해줌
         }).done((res) => {
             if(res.data == 1){
                 console.log(res);
                 alert("수정 완료");
                 alert(JSON.stringify(res));
                 location.href="/";
             } else {
             alert("수정 실패");
             }
         }).fail((error)=>{
             alert("수정 실패 서버 에러");
         })
     },
};
index.init();
