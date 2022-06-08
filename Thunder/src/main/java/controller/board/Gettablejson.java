package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.mysql.cj.Session;

import dao.BoardDao;
import dto.Member;

@WebServlet("/board/Gettablejson")
public class Gettablejson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Gettablejson() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int memberno = ((Member)session.getAttribute("user")).getMemberno();
		int boardcategory = Integer.parseInt(request.getParameter("boardcategory"));
		JSONArray result = BoardDao.instance.getsearchlist(memberno, boardcategory);	
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
