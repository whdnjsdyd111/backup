package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.QnaDBBean;
import bookshop.bean.QnaDataBean;

public class QnaReplyFormAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		int qna_id = Integer.parseInt(request.getParameter("qna_id"));
		
		// qna_id�� �ش��ϴ� QnA�� ������
		QnaDBBean qnaProcess = QnaDBBean.getInstance();
		QnaDataBean qna = qnaProcess.updateGetArticle(qna_id);
		
		// QnA �亯�� �ʿ��� ������ ��
		int book_id = qna.getBook_id();
		String book_title = qna.getBook_title();
		String qna_content = qna.getQna_content();
		byte qora = 2;	// �亯��
		
		request.setAttribute("qna_id", new Integer(qna_id));
		request.setAttribute("book_id", new Integer(book_id));
		request.setAttribute("book_title", book_title);
		request.setAttribute("qna_content", qna_content);
		request.setAttribute("qora", new Integer(qora));
		request.setAttribute("type", new Integer(0));
		
		return "/mngr/qnaProcess/qnaReplyForm.jsp";
	}
}
