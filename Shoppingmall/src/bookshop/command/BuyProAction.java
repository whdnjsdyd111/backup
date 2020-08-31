package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.BuyDBBean;
import bookshop.bean.CartDBBean;
import bookshop.bean.CartDataBean;

public class BuyProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		// ���� ó���� �ʿ��� ������ �Ķ���Ϳ��� ��
		String account = request.getParameter("account");
		String deliveryName = request.getParameter("deliveryName");
		String deliveryTel = request.getParameter("deliveryTel");
		String deliveryAddress = request.getParameter("deliveryAddress");
		String buyer = request.getParameter("buyer");
		int count = 0;
		
		// ���� ó���� ���� ��ٱ����� ����� ��
		CartDBBean cartProcess = CartDBBean.getInstance();
		count = cartProcess.getListCount(buyer);
		List<CartDataBean> cartLists = cartProcess.getCart(buyer, count);
		
		// ��ٱ����� ���, ������, ��������, ����� ������
		// buy ���̺� �߰�
		BuyDBBean buyProcess = BuyDBBean.getInstance();
		buyProcess.insertBuy(cartLists, buyer, account, deliveryName, deliveryTel, deliveryAddress);
		
		request.setAttribute("orderStus", "�ֹ��Ϸ�");
		request.setAttribute("type", new Integer(1));
		
		return "/buy/buyPro.jsp";
	}
}
