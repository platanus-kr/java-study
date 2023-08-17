package org.platanus.webappboard.app.service;

import java.util.List;
import java.util.Optional;
import org.platanus.webappboard.app.entity.BoardEntity;
import org.platanus.webappboard.app.entity.BoardFileEntity;
import org.platanus.webappboard.app.repository.JpaBoardRepository;
import org.platanus.webappboard.common.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class JpaBoardServiceImplement implements JpaBoardService {

    @Autowired
    JpaBoardRepository jpaBoardRepository;

    @Autowired
    FileUtils fileUtils;

    @Override
    public List<BoardEntity> selectBoardList() throws Exception {
        return jpaBoardRepository.findAllByOrderByBoardIdxDesc();
    }

    @Override
    public void saveBoard(BoardEntity board,
        MultipartHttpServletRequest multipartHttpServletRequest) throws Exception {
        board.setCreatorId("admin");
        List<BoardFileEntity> list = fileUtils.parseFileInformation(multipartHttpServletRequest);
        if (CollectionUtils.isEmpty(list) == false) {
            board.setFileList(list);
        }
        jpaBoardRepository.save(board);

    }

    @Override
    public BoardEntity selectBoardDetail(int boardIdx) throws Exception {
        Optional<BoardEntity> optional = jpaBoardRepository.findById(boardIdx);
        if (optional.isPresent()) {
            BoardEntity board = optional.get();
            board.setHitCnt(board.getHitCnt() + 1);
            jpaBoardRepository.save(board);

            return board;
        } else {
            throw new NullPointerException();
        }
    }

    @Override
    public void deleteBoard(int boardIdx) {
        jpaBoardRepository.deleteById(boardIdx);
    }

    @Override
    public BoardFileEntity selectBoardFileInformation(int boardIdx, int idx) throws Exception {
        BoardFileEntity boardFile = jpaBoardRepository.findBoardFile(boardIdx, idx);
        return boardFile;
    }
}
