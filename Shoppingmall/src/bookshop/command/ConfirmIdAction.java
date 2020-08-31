package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.LogonDBBean;

public class ConfirmIdAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		
		// �־��� id�� �ߺ� ���θ� üũ�� ���� ��ȯ
		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.confirmId(id);
		
		request.setAttribute("check", new Integer(check));
		return "/member/confirmId.jsp";
	}
}
