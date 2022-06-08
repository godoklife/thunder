package controller.board;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/board/SummernoteImgUpload")
public class SummernoteImgUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SummernoteImgUpload() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
//		JSONObject jsonObject = new JSONObject();
//		JSONArray jsonArray = new JSONArray();
		
		// eclipse project path ->> 팀원마다 windows 사용자 이름이 달라서 지정 불가
		String tmpPath = "C:\\Users\\Public\\Pictures\\tmp";
		
		// 탐캣 서버 경로 ->> C:\Users\Matebook_14\eclipse-workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\mohae\img\tmp\
		//String tmpPath = request.getSession().getServletContext().getRealPath("/img/tmp");
		MultipartRequest mr = new MultipartRequest(request, tmpPath, 20971520, "utf-8", new DefaultFileRenamePolicy());
		
		String name = mr.getFilesystemName("file");
		
	/*	
	 * 	MultipartRequest로 파일명중복 해결 안되면 UUID로 리네이밍 하는걸로 바꿔버릴것.
	 * 	이하 해당 코드.
	 * 	
	 * 	String fileExtension = mr.getFilesystemName("file").substring(((mr.getFilesystemName("file").lastIndexOf("."))+1));
	 *	System.out.println("첨부파일확장자 : "+fileExtension);
	 *	String name = UUID.randomUUID().toString()+"."+fileExtension; 
	 *	
	 */
		
		tmpPath+="\\"+name;
		
		String imgPath="\\mohae\\img\\tmp\\"+name;
		
		FileInputStream fis = new FileInputStream(mr.getFile("file"));
		System.out.println("등록한 파일의 크기 : "+fis.available());
		System.out.println("임시저장경로 : "+tmpPath);
		
		byte[] bytes = new byte[fis.available()];
		fis.read(bytes);
		fis.close();
		
		FileOutputStream fos = new FileOutputStream(tmpPath);	// 이미지 임시저장경로 지정
		BufferedOutputStream bos = new BufferedOutputStream(fos, 4096);	// 저장 경로와 버퍼사이즈(4096바이트)지정
		bos.write(bytes);
		
		System.out.println("업로드한 파일 이름 : "+name);
		bos.close();
		fos.close();
		JSONObject object = new JSONObject();
		try {
			
			object.put("url", imgPath);
			object.put("responseCode", "success");
			
		} catch (Exception e) {
			System.out.println("SummernoteImgUpload_Json_Exception : "+e);
		}
		response.getWriter().print(object);
		
	}

}
