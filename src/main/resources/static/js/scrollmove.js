$("#container").scroll(function(){
    let elem = $("#container");
    let scrT = $(window).scrollTop();
    console.log(scrT); //스크롤 값 확인용
    if(elem[0].scrollHeight - elem.scrollTop() == elem.outerHeight()){
        //스크롤이 끝에 도달했을때 실행될 이벤트
        let last = "${boards.last}";
        if (last == "false"){
            var link = '?page=${boards.number+1}';
            location.href=link;
            // location.replace(link);
            // window.open(link);
        }
    }
});