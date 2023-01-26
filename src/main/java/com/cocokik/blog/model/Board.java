package com.cocokik.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.List;

@Data //getter setter
@AllArgsConstructor //생성자
@NoArgsConstructor //생성자
@Builder //빌더 패턴 객체 생성 옵션
@Entity //디비에 맞는 객체
public class Board {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 200)
    private String title;

//    @Lob //대용량 데이터를 쓸때 롱텍스트로 잡혀야 하는덷 타이니텍스트로 생성됨,,,
    @Column(columnDefinition = "MEDIUMTEXT")
    private String contents;

    @ColumnDefault("0") //string인 경우에는 쌍따옴표 안에 홀따옴표
    private int count;

    //DB Join Column 유저아이디 값 대신 유저 오브젝트 쓸수 있음 (ORM) 근데 어노테이션 많이 써야하
    @ManyToOne(fetch = FetchType.EAGER) //Many = Board , User = one
    //여기서는 기본이 EAGER 임 작성 안해도 됨
    @JoinColumn(name="userId") //FK
    private User user;

    @OrderBy("id desc")
    @JsonIgnoreProperties({"board"}) //reply 에서 보드를 참조할때 무한 참조를 막기 위해서. reply 에서  board 를 json 으로 반환 안하도록 막는다.
    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER) //연관관계의 주인이 아니다..(FK 가 아님) 디비에 컬럼생성 안함.
    //board 는 Reply 의 board 이다 (Reply의 Fkd의 board), 여기서는 기본이 LAZY 전략 이어서 EAGER 로 변경)
    //LAZY 는 필요할때 같이 디비에서 조회, EAGER는 board 셀렉할때 Reply도 무조건 같이 셀렉트한다.
    private List<Reply> replys;  //board를 셀렉트할때 reply도 필요하기 때문에...

    @CreationTimestamp
    private Timestamp createDate;
}
