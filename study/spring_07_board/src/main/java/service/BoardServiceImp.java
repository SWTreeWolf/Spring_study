package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import controller.BoardController;
import dao.BoardDAO;
import dto.BoardDTO;
import dto.PageDTO;

public class BoardServiceImp implements BoardService {
	private BoardDAO dao;

	public BoardServiceImp() {
		// TODO Auto-generated constructor stub
	}

	public void setDao(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public int countProcess() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public List<BoardDTO> listProcess(PageDTO pv) {
		// TODO Auto-generated method stub
		return dao.list(pv);
	}

	@Override
	public void insertProcess(BoardDTO dto) {
		// TODO Auto-generated method stub
		dao.save(dto);
	}

	@Override
	public BoardDTO contentProcess(int num) {
		// TODO Auto-generated method stub
		dao.readCount(num);
		return dao.content(num);
	}

	@Override
	public void reStepProcess(BoardDTO dto) {
		// TODO Auto-generated method stub
		dao.reStepCount(dto);
	}

	@Override
	public BoardDTO updateSelectProcess(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateProcess(BoardDTO dto, HttpServletRequest request) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteProcess(int num, HttpServletRequest request) {
		// TODO Auto-generated method stub

	}
}// end class
