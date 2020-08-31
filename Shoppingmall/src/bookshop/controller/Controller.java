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
	
	// ��ɾ�� ��ɾ� ó�� Ŭ������ ������ ����
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
		
		// initParams���� propertyConfig�� ���� �о��
		String props = config.getInitParameter("propertyConfig");
		String realFolder = "/property";	// properties ������ ����� ����
		
		// �� ���ø����̼� ��Ʈ ���
		ServletContext context = config.getServletContext();
		
		// realFolder �� �� ���ø����̼� �ý��ۻ��� ���� ��η� ����
		String realPath = context.getRealPath(realFolder) + "\\" + props;
		
		// ��ɾ�� ó�� Ŭ������ ���� ������ ������ Properties ��ü ����
		Properties pr = new Properties();
		FileInputStream f = null;
		
		try {
			// command.properties ������ ������ �о��
			f = new FileInputStream(realPath);
			
			// command.properties�� ������ Properties ��ü pr�� ����
			pr.load(f);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			if(f != null)
				try { f.close(); } catch (IOException ex) {}
		}
		
		// Set ��ä�� iterator() �޼ҵ带 ����� Iterator ��ü�� ��
		Iterator<?> iterator = pr.keySet().iterator();
		
		// Iterator ��ü�� ����� ��ɾ�� ó�� Ŭ������ commandMap�� ����
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
		requestPro(request, response);	// ��û ó�� �޼ҵ� ȣ��
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestPro(request, response);	// ��û ó�� �޼ҵ� ȣ��
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
