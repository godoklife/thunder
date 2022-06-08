package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import dao.BoardDao;
import dto.Board;
import dto.Member;

@WebServlet("/board/SaveSummernote")
public class SaveSummernote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SaveSummernote() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		
		String boardtitle = request.getParameter("boardtitle");
		String boardcontenttype = request.getParameter("boardcontenttype");
		int boardcategory = Integer.parseInt(request.getParameter("boardcategory"));
		boolean boardattachment = Boolean.parseBoolean(request.getParameter("boardattachment"));
		String summernoteContent = request.getParameter("summernoteContent");
		
		
		int memberno = ((Member)session.getAttribute("user")).getMemberno();
		
		
		System.out.println("서블릿연결됨. : "+summernoteContent);
		Board board = new Board(0, boardtitle, boardcontenttype, summernoteContent, 0, null, boardcategory, memberno, boardattachment);
			// 마지막 false는 첨부파일 여부, 조금 있다가 작업할것
		
		Byte result = BoardDao.instance.saveSummernote(board);
		response.getWriter().print(result); 
	}

}
