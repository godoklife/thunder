package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.BoardDao;

@WebServlet("/board/ViewBoard")
public class ViewBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ViewBoard() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int boardno = Integer.parseInt(request.getParameter("boardno"));
		int boardcategory = Integer.parseInt(request.getParameter("boardcategory"));
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.getWriter().print(BoardDao.instance.getBoard(boardno));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
