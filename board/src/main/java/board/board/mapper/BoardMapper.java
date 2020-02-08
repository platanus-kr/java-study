package board.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import board.board.dto.BoardDto;

@Mapper
public class BoardMapper {
	List<BoardDto> selectBoardList() throws Exception;
}
