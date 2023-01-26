package com.cocokik.blog.controller.api;

import com.cocokik.blog.config.auth.PrincipalDetail;
import com.cocokik.blog.dto.ReplySaveDto;
import com.cocokik.blog.dto.ResponseDto;
import com.cocokik.blog.model.Board;
import com.cocokik.blog.model.Reply;
import com.cocokik.blog.service.BoardService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
public class BoardApiController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        boardService.글저장(board, principalDetail.getUser());
        System.out.println("req complete");
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
    @PutMapping("/api/board/{id}")
    public ResponseDto<Integer> updateById(@PathVariable int id, @RequestBody Board board){
        boardService.글수정(id, board);
        return new ResponseDto<Integer>(200, 1);
    }

    @DeleteMapping("/api/board/{id}")
    public ResponseDto<Integer> deleteById(@PathVariable int id) {
        boardService.글삭제(id);
        return new ResponseDto<Integer>(200, 1);
    }

    @PostMapping("/api/board/{id}/reply")
    public ResponseDto<Integer> replySave(@RequestBody ReplySaveDto reply) {
        boardService.댓글작성(reply);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @DeleteMapping("/api/board/{id}/reply/{replyId}")
    public ResponseDto<Integer> replyDelete(@PathVariable int replyId) {
        boardService.댓글삭제(replyId);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
