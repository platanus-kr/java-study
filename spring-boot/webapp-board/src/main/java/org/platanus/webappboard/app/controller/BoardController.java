package org.platanus.webappboard.app.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.platanus.webappboard.app.dto.BoardDto;
import org.platanus.webappboard.app.dto.BoardFileDto;
import org.platanus.webappboard.app.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {

//    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BoardService boardService;

    @RequestMapping("/board/openBoardList.do")
    public ModelAndView openBoardList() throws Exception {
//        log.debug("openBoardList");

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
    public String insertBoard(BoardDto board,
        MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        boardService.insertBoard(board, multipartHttpServletRequest);
        return "redirect:/board/openBoardList.do";
    }

    @RequestMapping("/board/openBoardDetail.do")
    public ModelAndView openBoardDetail(@RequestParam int boardIdx) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/board/boardDetail");

        BoardDto board = boardService.selectBoardDetail(boardIdx);
        modelAndView.addObject("board", board);

        return modelAndView;
    }

    @RequestMapping("/board/downloadBoardFile.do")
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

    @RequestMapping("/board/updateBoard.do")
    public String updateBoard(BoardDto board) throws Exception {
        boardService.updateBoard(board);
        return "redirect:/board/openBoardList.do";
    }

    @RequestMapping("/board/deleteBoard.do")
    public String deleteBoard(int boardIdx) throws Exception {
        boardService.deleteBoard(boardIdx);
        return "redirect:/board/openBoardList.do";
    }

}
