package bookshop.command;

import java.sql.Timestamp;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import bookshop.bean.MngrDBBean;
import bookshop.bean.MngrDataBean;

public class BookUpdateProAction implements CommandAction {
	 @Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		 request.setCharacterEncoding("utf-8");
		 
		 String filename = "";
		 String realFolder = "";	// 웹 애플리케이션 상의 절대 경로 저장
		 String saveFolder = "/bookImage";	// 파일 업로드 폴더 지정
		 String encType = "utf-8";	// 인코딩 타입
		 int maxSize = 1 * 1024 * 1024;	// 최대 업로드될 파일 크기 1Mb
		 
		 MultipartRequest imageUp = null;
		 
		 // 웹 애플리케이션 상의 절대 경로를 구함
		 ServletContext context = request.getSession().getServletContext();
		 realFolder = context.getRealPath(saveFolder);
		 
		 try {
			// 파일 업로드를 수행하는 MultipartRequest 객체 생성
			imageUp = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			
			// <input type="file">인 모든 파라미터를 얻어냄
			Enumeration<?> files = imageUp.getFileNames();
			
			// 파일 정보가 있다면
			while(files.hasMoreElements()) {
				// input 태그의 속성이 file인 태그의 name 속성값 : 파라미터 이름
				String name = (String) files.nextElement();
				
				// 서버에 저장된 파일 이름
				filename = imageUp.getFilesystemName(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		// 폼으로부터 넘어온 정보 중 파일이 아닌 정보를 얻어냄
			MngrDataBean book = new MngrDataBean();
			int book_id = Integer.parseInt(imageUp.getParameter("book_id"));
			String book_kind = imageUp.getParameter("book_kind");
			String book_title = imageUp.getParameter("book_title");
			String book_price = imageUp.getParameter("book_price");
			String book_count = imageUp.getParameter("book_count");
			String author = imageUp.getParameter("author");
			String publishing_com = imageUp.getParameter("publishing_com");
			String book_content = imageUp.getParameter("book_content");
			String discount_rate = imageUp.getParameter("discount_rate");
			
			// 책 등록일 계산
			String year = imageUp.getParameter("publishing_year");
			String month = (imageUp.getParameter("publishing_month").length() == 1) ? 
					"0" + imageUp.getParameter("publishing_month") : imageUp.getParameter("publishing_month");
					
			String day = (imageUp.getParameter("publishing_month").length() == 1) ? 
					"0" + imageUp.getParameter("publishing_month") : imageUp.getParameter("publishing_month");
					
			book.setBook_kind(book_kind);
			book.setBook_title(book_title);
			book.setBook_price(Integer.parseInt(book_price));
			book.setBook_count(Short.parseShort(book_count));
			book.setAuthor(author);
			book.setPublishing_com(publishing_com);
			book.setPublishing_date(year + "-" + month + "-" + day);
			book.setBook_image(filename);
			book.setBook_content(book_content);
			book.setDiscount_rate(Byte.parseByte(discount_rate));
			book.setReg_date(new Timestamp(System.currentTimeMillis()));
			
			// DB 연동 - 넘어온 정보를 테이블의 레코드로 추가
			MngrDBBean bookProcess = MngrDBBean.getInstance();
			bookProcess.updateBook(book, book_id);

			request.setAttribute("book_kind", book_kind);
			return "/mngr/productProcess/bookUpdatePro.jsp";
	}
}
