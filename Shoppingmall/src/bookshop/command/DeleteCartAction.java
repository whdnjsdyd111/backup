package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.CartDBBean;

public class DeleteCartAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String list = request.getParameter("list");
		String msg = "";
		
		CartDBBean bookProcess = CartDBBean.getInstance();
		
		if(list.equals("all")) {	// list ���� "all"�̸� ����
			// �ش� buyer�� ��ٱ��� ����� ��� ����
			String buyer = request.getParameter("buyer");
			bookProcess.deleteAll(buyer);
			msg = "��ٱ��ϰ� ��� ��������ϴ�.";
		} else {	// list ���� "all" �̿� (cart_id)�� ���̸� ����
			bookProcess.deleteList(Integer.parseInt(list));
			msg = "������ �׸��� �����Ǿ����ϴ�.";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("type", new Integer(1));
		return "/cart/deleteCart.jsp";
	}
}
