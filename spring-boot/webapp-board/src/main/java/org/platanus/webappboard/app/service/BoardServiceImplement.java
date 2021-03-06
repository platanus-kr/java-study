package org.platanus.webappboard.app.service;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.platanus.webappboard.app.dto.BoardDto;
import org.platanus.webappboard.app.dto.BoardFileDto;
import org.platanus.webappboard.app.mapper.BoardMapper;
import org.platanus.webappboard.common.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
@Transactional
@Slf4j
public class BoardServiceImplement implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return boardMapper.selectBoardList();
    }

    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest)
        throws Exception {
        boardMapper.insertBoard(board);
        FileUtils parsedFile = new FileUtils(board.getBoardIdx(), multipartHttpServletRequest);
        List<BoardFileDto> fileList = parsedFile.parseFileInfomation();
        if (!CollectionUtils.isEmpty(fileList)) {
            boardMapper.insertBoardFileList(fileList);
        }

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
