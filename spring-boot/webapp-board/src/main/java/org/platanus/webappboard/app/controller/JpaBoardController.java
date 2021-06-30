package org.platanus.webappboard.app.controller;

import java.io.File;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.FileUtils;
import org.platanus.webappboard.app.entity.BoardEntity;
import org.platanus.webappboard.app.entity.BoardFileEntity;
import org.platanus.webappboard.app.service.JpaBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JpaBoardController {

    @Autowired
    private JpaBoardService jpaBoardService;

    @RequestMapping(value = "/jpa/board", method = RequestMethod.GET)
    public ModelAndView openBoardList(ModelMap model) throws Exception {
        ModelAndView mv = new ModelAndView("/board/jpaBoardList");

        List<BoardEntity> list = jpaBoardService.selectBoardList();
        mv.addObject("list", list);

        return mv;
    }

    @RequestMapping(value = "/jpa/board/write", method = RequestMethod.GET)
    public String openBoardWrite() throws Exception {
        return "/board/jpaBoardWrite";
    }

    @RequestMapping(value = "/jpa/board/write", method = RequestMethod.POST)
    public String writeBoard(BoardEntity board,
        MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        jpaBoardService.saveBoard(board, multipartHttpServletRequest);
        return "redirect:/jpa/board";

    }

    @RequestMapping(value = "/jpa/board/{boardIdx}", method = RequestMethod.GET)
    public ModelAndView openBoardDetail(@PathVariable("boardIdx") int boardIdx) throws Exception {
        ModelAndView modelAndView = new ModelAndView("/board/jpaBoardDetail");

        BoardEntity board = jpaBoardService.selectBoardDetail(boardIdx);
        modelAndView.addObject("board", board);

        return modelAndView;
    }

    @RequestMapping(value = "/jpa/board/{boardIdx}", method = RequestMethod.PUT)
    public String updateBoard(BoardEntity board) throws Exception {
        jpaBoardService.saveBoard(board, null);
        return "redirect:/jpa/board";
    }

    @RequestMapping(value = "/jpa/board/{boardIdx}", method = RequestMethod.DELETE)
    public String deleteBoard(@PathVariable("boardIdx") int boardIdx) throws Exception {
        jpaBoardService.deleteBoard(boardIdx);
        return "redirect:/jpa/board";
    }


    @RequestMapping(value = "/jpa/board/file", method = RequestMethod.GET)
    public void downloadBoardFile(
        @RequestParam int idx,
        @RequestParam int boardIdx,
        HttpServletResponse response) throws Exception {
        BoardFileEntity boardFile = jpaBoardService.selectBoardFileInformation(idx, boardIdx);

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


}
