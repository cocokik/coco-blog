package com.cocokik.blog.service;

import com.cocokik.blog.dto.ReplySaveDto;
import com.cocokik.blog.model.Board;
import com.cocokik.blog.model.Reply;
import com.cocokik.blog.model.User;
import com.cocokik.blog.repository.BoardRepository;
import com.cocokik.blog.repository.ReplyRepository;
import com.cocokik.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.PublicKey;
import java.util.List;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private ReplyRepository replyRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional //여러 트랜잭션을 하나의 서비스로 관리하기 위해서 서비스 사용 -> 중간에 에러나면 롤백
    public void 글저장(Board board, User user) {
        board.setUser(user);
        board.setCount(0);
        boardRepository.save(board);
    }
    @Transactional(readOnly = true)
    public Page<Board> 메인글목록(Pageable pageable) {
        return boardRepository.findAll(pageable);
     }

     @Transactional(readOnly = true)
    public Board 상세글찾기(int id) {
        return boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("the board id doesn't exist id : " +id));
    }

    @Transactional
    public void 글삭제(int id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void 글수정(int id, Board board) {
        Board board1 = boardRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("수정할 데이터 없음.")); //영속화
        board1.setContents(board.getContents());
        board1.setTitle(board.getTitle());
        //트랜잭션 종료시 더티체킹 일어남 -> 영속화된 데이터가 달라졌으므로 디비로 자동 업데이트 된다(플러시, 커밋)
    }

    @Transactional
    public void 댓글작성(ReplySaveDto rpy) {
        int result = replyRepository.replySave(rpy.getUserId(), rpy.getBoardId(), rpy.getContent());
        System.out.println(result);
    }
}
