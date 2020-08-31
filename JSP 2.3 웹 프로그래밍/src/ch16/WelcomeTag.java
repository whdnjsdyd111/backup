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
		
		return SKIP_BODY;	// body�� ������ �˸��� �±��̴�. �±� �ڿ� '/>' ó���� �Ѵ�.
	}
}