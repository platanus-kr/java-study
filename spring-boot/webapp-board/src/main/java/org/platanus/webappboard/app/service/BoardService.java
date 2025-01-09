package org.platanus.webappboard.app.service;

import org.platanus.webappboard.app.dto.BoardDto;
import org.platanus.webappboard.app.dto.BoardFileDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

public interface BoardService {

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception;

    BoardDto selectBoardDetail(int boardIdx) throws Exception;

    BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int boardIdx) throws Exception;


}
