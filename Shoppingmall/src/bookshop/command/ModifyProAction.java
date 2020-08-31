package bookshop.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.bean.LogonDBBean;
import bookshop.bean.LogonDataBean;

public class ModifyProAction implements CommandAction {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		// ������ ȸ�� ����
		LogonDataBean member = new LogonDataBean();
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
		member.setName(request.getParameter("name"));
		member.setAddress(request.getParameter("address"));
		member.setTel(request.getParameter("tel"));
		
		// ������ ȸ�� ������ ������ ���� ó�� �� ���� ���� ��ȯ
		LogonDBBean manager = LogonDBBean.getInstance();
		int check = manager.updateMember(member);
		
		request.setAttribute("check", new Integer(check));
		return "/member/modifyPro.jsp";
	}
}
