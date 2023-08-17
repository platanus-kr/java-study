package org.platanus.webappboard.app.service;

import lombok.extern.slf4j.Slf4j;
import org.platanus.webappboard.app.dto.BoardDto;
import org.platanus.webappboard.app.dto.BoardFileDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

@Service
@Transactional
@Slf4j
public class BoardServiceImplement implements BoardService {

    @Override
    public List<BoardDto> selectBoardList() throws Exception {
        return null;
    }

    @Override
    public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest)
            throws Exception {

    }

    @Override
    public BoardDto selectBoardDetail(int boardIdx) throws Exception {
        return null;
    }

    @Override
    public BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception {
        return null;
    }

    @Override
    public void updateBoard(BoardDto board) throws Exception {

    }

    @Override
    public void deleteBoard(int boardIdx) throws Exception {

    }

//    @Autowired
//    private BoardMapper boardMapper;
//
//    @Override
//    public List<BoardDto> selectBoardList() throws Exception {
//        return boardMapper.selectBoardList();
//    }
//
//    @Override
//    public void insertBoard(BoardDto board, MultipartHttpServletRequest multipartHttpServletRequest)
//        throws Exception {
//        boardMapper.insertBoard(board);
//        FileUtils parsedFile = new FileUtils(board.getBoardIdx(), multipartHttpServletRequest);
//        List<BoardFileDto> fileList = parsedFile.parseFileInformation();
//        if (!CollectionUtils.isEmpty(fileList)) {
//            boardMapper.insertBoardFileList(fileList);
//        }
//
//    }
//
//    @Override
//    public BoardDto selectBoardDetail(int boardIdx) throws Exception {
//
//        BoardDto board = boardMapper.selectBoardDetail(boardIdx);
//        List<BoardFileDto> fileList = boardMapper.selectBoardFileList(boardIdx);
//        board.setFileList(fileList);
//
//        boardMapper.updateHitCount(boardIdx);
//
//        return board;
//    }
//
//    @Override
//    public BoardFileDto selectBoardFileInformation(int idx, int boardIdx) throws Exception {
//        return boardMapper.selectBoardFileInformation(idx, boardIdx);
//    }
//
//    @Override
//    public void updateBoard(BoardDto board) throws Exception {
//        boardMapper.updateBoard(board);
//
//    }
//
//    @Override
//    public void deleteBoard(int boardIdx) throws Exception {
//
//        boardMapper.deleteBoard(boardIdx);
//    }

}
