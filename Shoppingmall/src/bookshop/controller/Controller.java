package bookshop.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookshop.command.CommandAction;

/**
 * Servlet implementation class Controller
 */
@WebServlet(
		urlPatterns = { 
				"/Controller", 
				"*.do"
		}, 
		initParams = { 
				@WebInitParam(name = "propertyConfig", value = "commandMapping.properties")
		})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 명령어와 명령어 처리 클래스를 쌍으로 저장
	private Map<String, Object> commandMap = new HashMap<>();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		
		// initParams에서 propertyConfig의 값을 읽어옴
		String props = config.getInitParameter("propertyConfig");
		String realFolder = "/property";	// properties 파일이 저장된 폴더
		
		// 웹 애플리케이션 루트 경로
		ServletContext context = config.getServletContext();
		
		// realFolder 를 웹 애플리케이션 시스템상의 절대 경로로 변경
		String realPath = context.getRealPath(realFolder) + "\\" + props;
		
		// 명령어와 처리 클래스의 매핑 정보를 저장할 Properties 객체 생성
		Properties pr = new Properties();
		FileInputStream f = null;
		
		try {
			// command.properties 파일의 내용을 읽어옴
			f = new FileInputStream(realPath);
			
			// command.properties의 내용을 Properties 객체 pr에 저장
			pr.load(f);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(f != null)
				try { f.close(); } catch (IOException ex) {}
		}
		
		// Set 객채의 iterator() 메소드를 사용해 Iterator 객체를 얻어냄
		Iterator<?> iterator = pr.keySet().iterator();
		
		// Iterator 객체에 저장된 명령어와 처리 클래스를 commandMap에 저장
		while(iterator.hasNext()) {
			String command = (String) iterator.next();
			String className = pr.getProperty(command);
			try {
				Class<?> commandClass = Class.forName(className);
				Object commandIstance = commandClass.newInstance();
				commandMap.put(command, commandIstance);
			} catch(ClassNotFoundException e) {
				e.printStackTrace();
			} catch(InstantiationException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestPro(request, response);	// 요청 처리 메소드 호출
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestPro(request, response);	// 요청 처리 메소드 호출
	}

	private void requestPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = null;
		CommandAction com = null;
		
		try {
			String command = request.getRequestURI();

			if(command.indexOf(request.getContextPath()) == 0)
					command = command.substring(request.getContextPath().length());

			com = (CommandAction) commandMap.get(command);
			view = com.requestPro(request, response);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		request.setAttribute("cont", view);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}
}
