package org.platanus.webappboard.controller;

import java.util.List;
import org.platanus.webappboard.dto.BoardDto;
import org.platanus.webappboard.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping("/board/openBoardList.do")
    public ModelAndView openBoardList() throws Exception {
        ModelAndView modelAndView = new ModelAndView("/board/boardList");

        List<BoardDto> list = boardService.selectBoardList();
        modelAndView.addObject("list", list);

        return modelAndView;
    }

    @RequestMapping("/board/openBoardWrite.do")
    public String openBoardWrite() throws Exception {
        return "/board/boardWrite";
    }

    @RequestMapping("/board/insertBoard.do")
    public String insertBoard(BoardDto board) throws Exception {
        boardService.insertBoard(board);
        return "redirect:/board/openBoardList.do";
    }

}
