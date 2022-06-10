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
import dao.ProductDao;
import dto.Board;
import dto.Member;
import dto.Product;

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
		byte boardcategory = (byte)(Integer.parseInt(request.getParameter("boardcategory"))) ;
		String boardcontent = request.getParameter("summernoteContent");
		long memberno = Integer.parseInt(request.getParameter("memberno"));
		Board board = new Board(0, boardcategory, 0, boardtitle, boardcontenttype, boardcontent, 0, null, memberno);
		
		System.out.println("서블릿연결됨. : "+boardcontent);
		
		int boardPK = BoardDao.instance.saveSummernote(board);
		
		if(boardPK==-1) {
			response.getWriter().print(0);	// SQL 예외 발생
			return;
		}else {
			byte productactive = (byte)(Integer.parseInt(request.getParameter("productactive")));
			String productqulity = request.getParameter("productqulity");
			long productprice = Long.parseLong(request.getParameter("productprice"));
			String productcoordinate = request.getParameter("productcoordinate");
			Product product = new Product(0, productactive, productqulity, productprice, productcoordinate, boardPK);
			
			if(ProductDao.instance.create(product)) {
				response.getWriter().print(1);
			}else {
				response.getWriter().print(0);
			}
		}
	}
}
