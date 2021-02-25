package org.platanus.webappboard.service;

import java.util.List;
import org.platanus.webappboard.dto.BoardDto;

public interface BoardService {

    List<BoardDto> selectBoardList() throws Exception;

    void insertBoard(BoardDto board) throws Exception;

}
