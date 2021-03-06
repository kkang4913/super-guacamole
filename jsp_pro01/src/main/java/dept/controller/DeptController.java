package dept.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dept.model.DeptDTO;
import dept.service.DeptService;

@WebServlet("/depts")
public class DeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DeptService service = new DeptService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session =  request.getSession();
		
		if(session.getAttribute("loginData") == null) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		String search = request.getParameter("search"); //리퀘스트는 전부 문자열
		String page = request.getParameter("page");
		String sort= "deptId";
		int count = 5;
		
		
		
		if(session.getAttribute("pgc") != null) {
		     count =Integer.parseInt(session.getAttribute("pgc").toString());
		}
		
		if(session.getAttribute("sort") != null) {
			sort = (String)session.getAttribute("sort");
		}
		
		if(request.getParameter("pgc") !=null) {
			count =Integer.parseInt(request.getParameter("pgc"));
		}
		
		if(request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
		}
		
		session.setAttribute("pgc", count);
		session.setAttribute("sort", sort);
		/*
		Cookie cookies[] = request.getCookies();
		for(Cookie c: cookies) {
			if (c.getName().equals("pgc")) {
				count = Integer.parseInt(c.getValue());
			}
		}
		Cookie cookie = null;
		if (request.getParameter("pgc") !=null) {
		count =Integer.parseInt(request.getParameter("pgc"));
			cookie = new Cookie("pgc",request.getParameter("pgc"));
		}else {
			cookie = new Cookie("pgc",String.valueOf(count));
		}
		cookie.setMaxAge(30);
		cookie.setPath("depts");
		response.addCookie(cookie);
		*/
		request.setAttribute("pgc", count);
		//System.out.println(search);
		request.setAttribute("menuLocation", "depts");
		/*
		if(page == null) {
			page= "1";
		}
		*/
		//input 값에 숫자 범위가 아닐시 
		List<DeptDTO> datas =null;
		if(search == null) {
			int pageNum =1;
			if (page != null ) {
				if (!page.isEmpty() && page.matches("\\d+")) {
					pageNum = Integer.parseInt(page);
				}
			}
			datas = service.getPage(pageNum,count,sort);
			request.setAttribute("pageList", service.getPageNumberList(count));
			request.setAttribute("page", pageNum);
		}else {								//matches: 정규표현식 사용하는 방법
			//boolean isNumber = search.matches("\\d+"); //정규표현식 사용
			//if(isNumber) {
			DeptDTO data = service.getDeptId(search);
			////문자열을 인트형으로 변환 Integer.parseInt
			if(data != null) {
				datas = new ArrayList<DeptDTO>();
				datas.add(data);
			}
		} 
	//}
		
		request.setAttribute("datas", datas);
		// datas 서블릿을 jsp에 전달하기 위해 사용하는 방법
		
		String view = "/WEB-INF/jsp/dept/index.jsp";
		request.getRequestDispatcher(view).forward(request, response);
	}

}
