package class06.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceClient {
	public static void main(String[] args) {
		// 1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext context =
				new GenericXmlApplicationContext("class06/board/applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 BoardServicImp 객체를 Lookup한다.
		BoardService boardService = (BoardService) context.getBean("boardService");
		
		// 3. 글 등록 기능 테스트
		BoardDTO dto = new BoardDTO();
		dto.setTitle("임시 제목");
		dto.setWriter("홍길동");
		dto.setContent("임시 내용....");
		boardService.insertBoard(dto);
		
		// 4. 글 목록 검색 기능 테스트
		List<BoardDTO> boardList = boardService.getBoardList(dto);
		for(BoardDTO board : boardList) {
			System.out.println("--->" + board.toString());
		}
		
		// 5. Spring 컨테이너 종료
		context.close();
	}//end main()
}//end class
