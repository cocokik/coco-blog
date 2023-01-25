let index = {
    init: function(){
        $("#btn_save").on("click",()=>{
                    console.log(this)
                    this.save();
                });
        $("#btn_update").on("click",()=>{
                    console.log(this)
                    this.update();
                });
        },
    save: function(){
        let data={
            userName: $("#username").val(),
            passWord: $("#password").val(),
            email: $("#email").val(),};
        console.log(data);
        //ajax default = 비동기 호출
        $.ajax({
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(data), //바디 데이터
            contentType: "application/json; char=utf-8", //body data type
            dataType: "json" //응답 데이터 타입 은 기본으로 문자열인데 json 으로 하고 스트링이 json 인 경우 자바스크립트 객체로 변경해줌
        }).done((res) => {
            if(res.data == 1){
                console.log(res);
                location.href="/";
            } else {
            alert("회원가입 실패");
            }
        }).fail((error)=>{
            alert(JSON.stringify(error));
        })
    },
    update: ()=>{
            let data={
                id: $("#id").val(),
                passWord: $("#password").val(),
                email: $("#email").val(),};
            console.log(data);
            //ajax default = 비동기 호출
            $.ajax({
                type: "PUT",
                url: "/api/userUpdate",
                data: JSON.stringify(data), //바디 데이터
                contentType: "application/json; char=utf-8", //body data type
                dataType: "json" //응답 데이터 타입 은 기본으로 문자열인데 json 으로 하고 스트링이 json 인 경우 자바스크립트 객체로 변경해줌
            }).done((res) => {
                if(res.data == 1){
                    console.log(res);
                    alert("회원수정 완료");
                    location.href="/";
                } else {
                alert("회원수정 실패");
                }
            }).fail((error)=>{
                alert(JSON.stringify(error));
            })
        },
};
index.init();
