package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.LogonDBBean;

public class LoginProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// ����ڰ� �Է��� id, passwd�� ������ ���� üũ �� �� ��ȯ
		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.userCheck(id, passwd);
		
		request.setAttribute("id", id);
		request.setAttribute("check", new Integer(check));
		return "/member/loginPro.jsp";
	}
}
