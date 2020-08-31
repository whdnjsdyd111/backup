package bookshop.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.MngrDBBean;
import bookshop.bean.MngrDataBean;

public class ShopMainAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		MngrDataBean bookList[] = null;
		List<MngrDataBean[]> bookLists = new ArrayList<>();
		
		MngrDBBean bookProcess = MngrDBBean.getInstance();	// DB ����
		
		// ī�װ��� �ֽ��� ��ǰ 3���� ���� List�� ����
		for (int i = 1; i <= 3; i++) {
			bookList = bookProcess.getBooks(i + "00", 3);
			bookLists.add(bookList);
		}
		
		// �ش� �������� ���� ���� ����
		request.setAttribute("bookLists", bookLists);
		
		// ����� ȭ���� �ǹ��ϴ� ���� ����
		request.setAttribute("type", new Integer(1));
		
		
		return "/shop/shopMain.jsp";
	}
}
