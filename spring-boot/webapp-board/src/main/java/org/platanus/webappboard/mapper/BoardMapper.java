package org.platanus.webappboard.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.platanus.webappboard.dto.BoardDto;

@Mapper
public interface BoardMapper {

    List<BoardDto> selectBoardList() throws Exception;
}
