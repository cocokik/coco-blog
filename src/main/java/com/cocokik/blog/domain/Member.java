package com.cocokik.blog.domain;

import lombok.*;

//@Getter
//@Setter
@Data //getter, setter 만들아줌
//@AllArgsConstructor
@NoArgsConstructor
public class Member {
    private int id;
    private String name;
    private String pw;
    private String email;

    @Builder //객체 생성할때 빌드 함수 사용 가능
    public Member(int id, String name, String pw, String email) {
        this.id = id;
        this.name = name;
        this.pw = pw;
        this.email = email;
    }
}
