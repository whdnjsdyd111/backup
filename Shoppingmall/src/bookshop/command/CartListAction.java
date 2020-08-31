package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.CartDBBean;
import bookshop.bean.CartDataBean;

public class CartListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String buyer = request.getParameter("buyer");
		
		List<CartDataBean> cartLists = null;
		int count = 0;
		
		// �ش� buyer�� ��ٱ��� ����� ���� ��
		CartDBBean bookProcess = CartDBBean.getInstance();
		count = bookProcess.getListCount(buyer);
		
		if(count > 0) {	// �ش� buyer�� ��ٱ��� ����� ������ ����
			// �ش� buyer�� ��ٱ��� ����� ��
			cartLists = bookProcess.getCart(buyer, count);
			request.setAttribute("cartLists", cartLists);
		}
		
		request.setAttribute("count", new Integer(count));
		request.setAttribute("type", new Integer(1));
		
		
		return "/cart/cartList.jsp";
	}
}
