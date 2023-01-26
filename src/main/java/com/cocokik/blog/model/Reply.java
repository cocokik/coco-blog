package com.cocokik.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;

@Data //getter setter
@AllArgsConstructor //생성자
@NoArgsConstructor //생성자
@Builder //빌더 패턴 객체 생성 옵션
@Entity //user 클래스가 자동으로 테이블을 생성한다.
public class Reply {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 200)
    private String content;

    @ManyToOne
    @JoinColumn(name="boardId")
    private Board board;

    @ManyToOne
    @JoinColumn(name="userId")
    private User user;

    @CreationTimestamp
    private Timestamp createDate;

    @Override //오브젝트를 찍으면 toString 이 자동으로 실행됨.
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", board=" + board +
                ", user=" + user +
                ", createDate=" + createDate +
                '}';
    }
}
