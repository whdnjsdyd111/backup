package ch16;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class WelcomeTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("Welcome to My Custom Tag");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;	// body가 없음을 알리는 태그이다. 태그 뒤에 '/>' 처리를 한다.
	}
}