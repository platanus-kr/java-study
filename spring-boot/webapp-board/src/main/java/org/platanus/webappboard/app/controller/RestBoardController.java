package org.platanus.webappboard.app.controller;


import org.apache.commons.io.FileUtils;
import org.platanus.webappboard.app.dto.BoardDto;
import org.platanus.webappboard.app.dto.BoardFileDto;
import org.platanus.webappboard.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class RestBoardController {

    @Autowired
    private BoardService boardService;

    @RequestMapping(value = "/board", method = RequestMethod.GET)
    public ModelAndView openBoardList() throws Exception {
        ModelAndView modelAndView = new ModelAndView("/board/restBoardList");

        List<BoardDto> list = boardService.selectBoardList();
        modelAndView.addObject("list", list);

        return modelAndView;
    }

    @RequestMapping(value = "/board/write", method = RequestMethod.GET)
    public String openBoardWrite() throws Exception {
        return "/board/restBoardWrite";
    }


    @RequestMapping(value = "/board/write", method = RequestMethod.POST)
    public String insertBoard(
            BoardDto board,
            MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        boardService.insertBoard(board, multipartHttpServletRequest);
        return "redirect:/board";
    }

    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.GET)
    public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/board/restBoardDetail");

        BoardDto board = boardService.selectBoardDetail(boardIdx);
        modelAndView.addObject("board", board);

        return modelAndView;
    }

    @RequestMapping(value = "/board/file", method = RequestMethod.GET)
    public void downloadBoardFile(
            @RequestParam int idx,
            @RequestParam int boardIdx,
            HttpServletResponse response) throws Exception {
        BoardFileDto boardFile = boardService.selectBoardFileInformation(idx, boardIdx);

        if (!ObjectUtils.isEmpty(boardFile)) {
            String fileName = boardFile.getOriginalFileName();

            byte[] files = FileUtils.readFileToByteArray(
                    new File(boardFile.getStoredFilePath()));

            response.setContentType("application/octet-stream");
            response.setContentLength(files.length);
            response.setHeader(
                    "Content-Disposition",
                    "attachment; fileName=\"" +
                            URLEncoder.encode(fileName, "UTF-8") +
                            "\";");
            response.setHeader(
                    "Content-Transfer-Encoding",
                    "binary");
            response.getOutputStream().write(files);
            response.getOutputStream().flush();
            response.getOutputStream().close();
        }
    }

    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.PUT)
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board";
    }

    @RequestMapping(value = "/board/{boardIdx}", method = RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
        boardService.deleteBoard(boardIdx);
        return "redirect:/board";
    }


}
