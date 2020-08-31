package ch17;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MessageProcess implements CommandProcess {
	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		request.setAttribute("message", "요청 파라미터로 명령어를 전달");
		return "/JSP 2.3 웹 프로그래밍/17 모델 2 기반의 MVC 패턴/02 컨트롤러인 서블릿에 사용자의 요청을 명령어로 전달/process.jsp";
	}
}
