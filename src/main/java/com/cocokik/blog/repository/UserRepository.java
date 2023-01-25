package com.cocokik.blog.repository;

import com.cocokik.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

//DAO
//자동으로 빈에 등록된다. 그래서 어노테이션 생략가능 @Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    //user 테이블을 관리하는 리파지토리 인티져는 유저의 프라이머리키 타입

    //JPA Naming query 전략
//    User findByUsernameAndPassword(String username, String password);

    //위랑 같은 내용! 간단한건 위처럼 복잡한건 밑에 처럼
    @Query(value = "select * from User where username=?1 and password=?2", nativeQuery = true)
    User login(String username, String password);

    Optional<User> findByUserName(String username);
}
