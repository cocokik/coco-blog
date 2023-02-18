package com.cocokik.blog.controller;

import com.cocokik.blog.config.auth.PrincipalDetail;
import com.cocokik.blog.model.Board;
import com.cocokik.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @GetMapping({"", "/"})
    public String index(Model model, @PageableDefault(size=10, sort ="id", direction = Sort.Direction.DESC) Pageable pageable){//Model model){ //@AuthenticationPrincipal PrincipalDetail principalDetail) {
        System.out.println("this is run");
        System.out.println("this is run");
        System.out.println("this is run");
//        System.out.println("#####" + principalDetail.getUsername() + " " + principalDetail.getPassword());
        // /WEB-INF/views/ ? .jsp
        model.addAttribute("boards", boardService.메인글목록(pageable));
        return "index";
    }


    @GetMapping("/board/{id}/updateForm")
    public String updateForm(@PathVariable int id, Model model) {
        model.addAttribute("board", boardService.상세글찾기(id));
        return "board/updateForm";
    }
    @GetMapping("/board/{id}")
    public String getFindById(@PathVariable int id, Model model ) {
        Board board = boardService.상세글찾기(id);
        model.addAttribute("board", board);
        return "board/detail";

    }
    @GetMapping("/board/saveForm")
    public String saveFormBoard(){
        return "board/saveForm";
    }

}
