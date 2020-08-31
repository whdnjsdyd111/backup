package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.MngrDBBean;
import bookshop.bean.MngrDataBean;

public class ProListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		List<MngrDataBean> bookList = null;
		int count = 0;
		String book_kind = request.getParameter("book_kind");
		
		MngrDBBean bookProcess = MngrDBBean.getInstance();
		
		// kind ���� all�̸� ��ü ��ǰ�� ���� ��
		if(book_kind.equals("all"))
			count = bookProcess.getBookCount();
		else	// all�� �ƴϸ� �ش� ī�װ��� ��ǰ ���� ��
			count = bookProcess.getBookCount(book_kind);
		
		if(count > 0) {	// ��ǰ�� ������ ����
			// ��ǰ ����� ��
			bookList = bookProcess.getBooks(book_kind);
			request.setAttribute("bookList", bookList);
		}
		
		// �ش� �信�� ����� �Ӽ�
		request.setAttribute("count", new Integer(count));
		request.setAttribute("book_kind", book_kind);
		request.setAttribute("type", new Integer(1));
		
		return "/shop/showList.jsp";
	}
}
