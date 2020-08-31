package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.MngrDBBean;
import bookshop.bean.MngrDataBean;

public class BookListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		List<MngrDataBean> bookList = null;
		String book_kind = request.getParameter("book_kind");
		int count = 0;
		
		// DB ���� - ��ü ��ǰ�� ���� ��
		MngrDBBean bookProcess = MngrDBBean.getInstance();
		count = bookProcess.getBookCount();
		
		if(count > 0) {	// ��ǰ�� ������ ����
			// ��ǰ ��ü�� ���̺��� ���� bookList�� ����
			bookList = bookProcess.getBooks(book_kind);
			
			// bookList�� �信�� ����� �� �ֵ��� request �Ӽ��� ����
			request.setAttribute("bookList", bookList);
		}
		
		// �信�� ����� �Ӽ�
		request.setAttribute("count", new Integer(count));
		request.setAttribute("book_kind", book_kind);
		request.setAttribute("type", new Integer(0));
		
		return "/mngr/productProcess/bookList.jsp";
	}
}
