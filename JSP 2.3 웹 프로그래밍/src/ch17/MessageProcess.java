package ch17;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageProcess implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("message", "��û �Ķ���ͷ� ��ɾ ����");
		return "/JSP 2.3 �� ���α׷���/17 �� 2 ����� MVC ����/02 ��Ʈ�ѷ��� ������ ������� ��û�� ��ɾ�� ����/process.jsp";
	}
}
