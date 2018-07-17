package class06.board;

import java.util.List;

public interface BoardService {
	void insertBoard(BoardDTO dto);
	void updateBoard(BoardDTO dto);
	void deleteBoard(BoardDTO dto);
	BoardDTO getBoard(BoardDTO dto);
	List<BoardDTO> getBoardList(BoardDTO dto);
}//end interface
