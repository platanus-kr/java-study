package org.platanus.webappboard.app.service;

import java.util.Iterator;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.platanus.webappboard.app.dto.BoardDto;
import org.platanus.webappboard.app.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;
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
//        boardMapper.insertBoard(board);
        if (ObjectUtils.isEmpty(multipartHttpServletRequest) == false) {
            Iterator<String> filenameIterator = multipartHttpServletRequest.getFileNames();
            String name;
            while (filenameIterator.hasNext()) {
                name = filenameIterator.next();
                log.debug("File name tag : " + name);
                List<MultipartFile> fileList = multipartHttpServletRequest.getFiles(name);
                for (MultipartFile multipartFile : fileList) {
                    log.debug("--- start file ---");
                    log.debug("File name : " + multipartFile.getOriginalFilename());
                    log.debug("File size : " + multipartFile.getSize());
                    log.debug("File content-type : " + multipartFile.getContentType());
                    log.debug("--- end file ---");

                }
            }
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
