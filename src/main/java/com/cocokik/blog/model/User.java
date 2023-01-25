package com.cocokik.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import java.sql.Timestamp;

@Data //getter setter
@AllArgsConstructor //생성자
@NoArgsConstructor //생성자
@Builder //빌더 패턴 객체 생성 옵션
@Entity //user 클래스가 자동으로 테이블을 생성한다.
//@DynamicInsert //인서트할때 널인 값은 제외하고 인서트해준다. (쿼리날릴때)
public class User {
    @Id //프라이머리 키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에 연결된 DB의 넘버링 전략을 따라간다.
    private int id;
    @Column(nullable = false, length = 30, unique = true)
    private String userName;

    @Column(nullable = true)
    private String oauth;
    @Column(nullable = false, length = 100)
    private String passWord;
    @Column(nullable = false, length = 100)
    private String email;
    @Enumerated(EnumType.STRING)
    private RoleType role; //enum 을 쓰는게 좋음 enum
    @CreationTimestamp //시간 자동 입력
    private Timestamp createDate;
}
