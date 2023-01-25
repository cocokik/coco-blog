package com.cocokik.blog.repository;

import com.cocokik.blog.model.Board;
import com.cocokik.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//DAO
//자동으로 빈에 등록된다. 그래서 어노테이션 생략가능 @Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    //Board 테이블을 관리하는 리파지토리 인티져는 Board의 프라이머리키 타입


}
