package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.BuyDBBean;
import bookshop.bean.BuyDataBean;

public class OrderListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub

		List<BuyDataBean> buyLists = null;
		int count = 0;
		
		// ��ü �ֹ� ����� ���� ��
		BuyDBBean buyProcess = BuyDBBean.getInstance();
		count = buyProcess.getListCount();
		
		if(count > 0) {	// �ֹ� ����� ������
			// ��ü �ֹ� ����� ��
			buyLists = buyProcess.getBuyList();
			request.setAttribute("buyLists", buyLists);
		}
		
		request.setAttribute("count", new Integer(count));
		request.setAttribute("type", new Integer(0));
		return "/mngr/orderedProduct/orderList.jsp";
	}
}
