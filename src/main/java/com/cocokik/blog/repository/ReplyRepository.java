package com.cocokik.blog.repository;


import com.cocokik.blog.model.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//@Repository
public interface ReplyRepository extends JpaRepository<Reply, Integer> {

    @Modifying
    @Query(value = "INSERT INTO Reply(userId, boardId, content, createDate) values(?1, ?2, ?3, now())", nativeQuery = true)
    int replySave(int userId, int boardId, String content); //작업 로우 수 리턴
}
