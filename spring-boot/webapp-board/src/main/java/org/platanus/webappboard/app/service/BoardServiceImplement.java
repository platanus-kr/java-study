package org.platanus.webappboard.app.service;

import java.util.List;
import org.platanus.webappboard.app.dto.BoardDto;
import org.platanus.webappboard.app.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BoardServiceImplement implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board) throws Exception {
        boardMapper.insertBoard(board);
    }

    @Override
    public BoardDto selectBoardDetail(int boardIdx) throws Exception {
        boardMapper.updateHitCount(boardIdx);

        BoardDto board = boardMapper.selectBoardDetail(boardIdx);

        return board;
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception {
        boardMapper.updateBoard(board);

    }

    @Override
    public void deleteBoard(int boardIdx) throws Exception {

        boardMapper.deleteBoard(boardIdx);
    }

}
