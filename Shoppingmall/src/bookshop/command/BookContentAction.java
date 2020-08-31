package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.MngrDBBean;
import bookshop.bean.MngrDataBean;
import bookshop.bean.QnaDBBean;
import bookshop.bean.QnaDataBean;

public class BookContentAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		List<QnaDataBean> qnaLists;
		String book_kind = request.getParameter("book_kind");
		int book_id = Integer.parseInt(request.getParameter("book_id"));
		
		// book_id�� �ش��ϴ� ��ǰ�� ��
		MngrDBBean bookProcess = MngrDBBean.getInstance();
		MngrDataBean book = bookProcess.getBook(book_id);
		
		// book_id�� �ش��ϴ� ��ǰ�� QnA ���� ��
		QnaDBBean qnaProcess = QnaDBBean.getInstance();
		int count = qnaProcess.getArticleCount(book_id);
		
		if(count > 0) {	// QnA�� ������ ����
			// book_id �� �ش��ϴ� ��ǰ�� QnA�� ��
			qnaLists = qnaProcess.getArticles(count, book_id);
			request.setAttribute("qnaLists", qnaLists);
		}
		
		request.setAttribute("book", book);
		request.setAttribute("book_id", new Integer(book_id));
		request.setAttribute("book_kind", book_kind);
		request.setAttribute("count", new Integer(count));
		request.setAttribute("type", new Integer(1));
		
		return "/shop/bookContent.jsp";
	}
}
