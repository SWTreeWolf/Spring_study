package controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import dto.BoardDTO;
import dto.PageDTO;
import service.BoardService;

@Controller
public class BoardController {
	private BoardService service;
	private int currentPage = 1;
	private PageDTO pdto;

	public BoardController() {
		// TODO Auto-generated constructor stub
	}

	public void setService(BoardService service) {
		this.service = service;
	}

	@RequestMapping(value = "/list.sb", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView listMethod(PageDTO pv, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int totalRecord = service.countProcess();
		String pageNum = request.getParameter("pageNum");

		if (pageNum == null) {
			pageNum = "0";
		}

		// currentPage = Integer.parseInt(pageNum);

		if (totalRecord >= 1) {
			if (pv.getCurrentPage() == 0) {
				currentPage = 1;
			} else {
				currentPage = pv.getCurrentPage();
			}
			// pdto 페이지 출력을 위함
			pdto = new PageDTO(currentPage, totalRecord);

			mav.addObject("aList", service.listProcess(pdto));
			mav.addObject("pv", pdto);
		}
		mav.setViewName("board/list");
		return mav;
	}// end listMethod()

	@RequestMapping("/view.sb")
	public ModelAndView viewMethod(int currentPage, int num) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("dto", service.contentProcess(num));
		mav.addObject("currentPage", currentPage);

		mav.setViewName("board/view");
		return mav;
	}// end viewMethod()//////

	@RequestMapping(value = "/write.sb", method = RequestMethod.GET)
	public ModelAndView writeMethod(PageDTO pv, BoardDTO dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("board/write");

		if (dto.getRef() != 0) {
			mav.addObject("currentPage", pv.getCurrentPage());
			mav.addObject("dto", dto);
		}

		return mav;
	}// end writeMethod()////

	// file경로
	@RequestMapping(value = "/write.sb", method = RequestMethod.POST)
	public String writeProMethod(BoardDTO dto, HttpServletRequest request) {
		MultipartHttpServletRequest multi = (MultipartHttpServletRequest) request;

		String writer = (String) multi.getParameter("writer");
		String email = (String) multi.getParameter("email");
		String subject = (String) multi.getParameter("subject");
		String content = (String) multi.getParameter("content");
		MultipartFile file = multi.getFile("filename");
		String filename = file.getOriginalFilename();
		
		dto.setSubject(subject);
		dto.setEmail(email);
		dto.setContent(content);
		dto.setWriter(writer);
		dto.setRe_level(0);
		dto.setRe_step(0);
		dto.setUpload(filename);

		// HttpServletRequest : 클라이언트가 요청한 정보를 받아옴
		// BoardDTO : 클라이언트가 입력한 정보를 받아옴 (멤버변수명과 파라미터명이 모두 같으면)
		String path = "c:/temp";

		File dir = new File(path);

		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		File serverFile = new File(path + File.separator + filename);
		try {
			file.transferTo(serverFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}

		if (dto.getRef() != 0) {
			int re_step = Integer.parseInt(multi.getParameter("re_step"));
			int re_level = Integer.parseInt(multi.getParameter("re_level"));
			dto.setRef(dto.getRef());
			dto.setRe_level(re_level);
			dto.setRe_step(re_step + 1);
			service.reStepProcess(dto);
		} else {
			service.insertProcess(dto);
		}

		return "redirect:/list.sb";
	}// end method()
}// end class
