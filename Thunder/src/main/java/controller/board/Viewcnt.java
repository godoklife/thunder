package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

@WebServlet("/board/Viewcnt")
public class Viewcnt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Viewcnt() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long boardpkno = Long.parseLong(request.getParameter("boardpkno"));
		BoardDao.instance.viewCnt(boardpkno);
	}


}
