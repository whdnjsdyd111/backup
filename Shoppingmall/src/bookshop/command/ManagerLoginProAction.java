package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.MngrDBBean;

public class ManagerLoginProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		// �Ѿ�� ��û�� �����͸� ��
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// DB�� �����ؼ� ������� ������ ó��
		MngrDBBean dbPro = MngrDBBean.getInstance();
		int check = dbPro.userCheck(id, passwd);
		
		// �ش� ��(���� ������)�� ���� ������ request �Ӽ��� ����
		request.setAttribute("check", new Integer(check));
		request.setAttribute("id", id);
		
		return "/mngr/logon/mLoginPro.jsp";
	}
}
