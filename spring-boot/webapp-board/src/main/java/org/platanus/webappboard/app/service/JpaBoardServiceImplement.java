package org.platanus.webappboard.app.service;

import java.util.List;
import org.platanus.webappboard.entity.BoardEntity;
import org.platanus.webappboard.entity.BoardFileEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class JpaBoardServiceImplement implements JpaBoardService {

    @Autowired
    JpaBoardRepository jpaBoardRepository;

    @Override
    public List<BoardEntity> selectBoardList() throws Exception {
        return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
    }

    @Override
    public void saveBoard(BoardEntity board,
        MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {

    }

    @Override
    public BoardEntity selectBoardDetail(int boardIdx) throws Exception {
        return null;
    }

    @Override
    public void deleteBoard(int boardIdx) {

    }

    @Override
    public BoardFileEntity selectBoardFileInformation(int boardIdx, int idx) throws Exception {
        return null;
    }
}
