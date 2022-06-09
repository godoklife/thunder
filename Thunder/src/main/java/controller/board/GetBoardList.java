package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.BoardDao;

@WebServlet("/board/GetBoardList")
public class GetBoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GetBoardList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		byte boardcategory = (byte)Byte.parseByte(request.getParameter("boardcategory"));
		
		response.getWriter().print(BoardDao.instance.getsearchlist(boardcategory));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
