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
		 String realFolder = "";	// �� ���ø����̼� ���� ���� ��� ����
		 String saveFolder = "/bookImage";	// ���� ���ε� ���� ����
		 String encType = "utf-8";	// ���ڵ� Ÿ��
		 int maxSize = 1 * 1024 * 1024;	// �ִ� ���ε�� ���� ũ�� 1Mb
		 
		 MultipartRequest imageUp = null;
		 
		 // �� ���ø����̼� ���� ���� ��θ� ����
		 ServletContext context = request.getSession().getServletContext();
		 realFolder = context.getRealPath(saveFolder);
		 
		 try {
			// ���� ���ε带 �����ϴ� MultipartRequest ��ü ����
			imageUp = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
			
			// <input type="file">�� ��� �Ķ���͸� ��
			Enumeration<?> files = imageUp.getFileNames();
			
			// ���� ������ �ִٸ�
			while(files.hasMoreElements()) {
				// input �±��� �Ӽ��� file�� �±��� name �Ӽ��� : �Ķ���� �̸�
				String name = (String) files.nextElement();
				
				// ������ ����� ���� �̸�
				filename = imageUp.getFilesystemName(name);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		// �����κ��� �Ѿ�� ���� �� ������ �ƴ� ������ ��
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
			
			// å ����� ���
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
			
			// DB ���� - �Ѿ�� ������ ���̺��� ���ڵ�� �߰�
			MngrDBBean bookProcess = MngrDBBean.getInstance();
			bookProcess.updateBook(book, book_id);

			request.setAttribute("book_kind", book_kind);
			return "/mngr/productProcess/bookUpdatePro.jsp";
	}
}
