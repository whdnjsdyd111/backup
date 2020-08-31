package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.BuyDBBean;
import bookshop.bean.CartDBBean;
import bookshop.bean.CartDataBean;
import bookshop.bean.LogonDBBean;
import bookshop.bean.LogonDataBean;

public class BuyFormAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String buyer = request.getParameter("buyer");
		
		List<CartDataBean> cartLists = null;
		List<String> accountLists = null;
		LogonDataBean member = null;
		int count = 0;
		
		// �ش� buyer�� ��ٱ��� ����� ���� ��
		CartDBBean bookProcess = CartDBBean.getInstance();
		count = bookProcess.getListCount(buyer);
		
		if(count > 0) {	// ��ٱ��� ����� ������ ����
			// ���ſ� �ʿ��� �ش� buyer�� ��ٱ��� ����� ��
			cartLists = bookProcess.getCart(buyer, count);
			request.setAttribute("cartLists", cartLists);
		}
		
		// ���ſ� �ʿ��� buyer�� ������ ��
		LogonDBBean memberProcess = LogonDBBean.getInstance();
		member = memberProcess.getMember(buyer);
		
		// ���ſ� �ʿ��� ���� ���¸� ��
		BuyDBBean buyProcess = BuyDBBean.getInstance();
		accountLists = buyProcess.getAccount();
		
		request.setAttribute("member", member);
		request.setAttribute("accountLists", accountLists);
		request.setAttribute("type", new Integer(1));
		
		return "/buy/buyForm.jsp";
	}
}
