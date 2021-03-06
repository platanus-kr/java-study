package org.platanus.webappboard.app.service;

import java.util.List;
import org.platanus.webappboard.app.dto.BoardDto;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface BoardService {

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest)
        throws Exception;

    BoardDto selectBoardDetail(int boardIdx) throws Exception;

    void updateBoard(BoardDto board) throws Exception;

    void deleteBoard(int boardIdx) throws Exception;


}
