package bookshop.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.BuyDBBean;
import bookshop.bean.BuyDataBean;

public class BuyListAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String buyer = request.getParameter("buyer");
		
		List<BuyDataBean> buyLists = null;
		int count = 0;
		
		// �ش� buyer�� ���� ����� ���� ��
		BuyDBBean buyProcess = BuyDBBean.getInstance();
		count = buyProcess.getListCount(buyer);
		
		if(count > 0) {	// ���� ����� ������ ����
			// �ش� buyer�� ���� ����� ��
			buyLists = buyProcess.getBuyList(buyer);
			request.setAttribute("buyLists", buyLists);
		}
		
		request.setAttribute("count", new Integer(count));
		request.setAttribute("type", new Integer(1));
		
		return "/buy/buyList.jsp";
	}
}
