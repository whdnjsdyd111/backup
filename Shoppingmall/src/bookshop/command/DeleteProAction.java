package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.LogonDBBean;

public class DeleteProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		
		// ����ڰ� �Է��� id, passwd�� ������ ȸ�� ���� ���� �� ���� ���� ��ȯ
		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.deleteMember(id, passwd);
		
		request.setAttribute("check", new Integer(check));
		return "/member/deletePro.jsp";
	}
}
