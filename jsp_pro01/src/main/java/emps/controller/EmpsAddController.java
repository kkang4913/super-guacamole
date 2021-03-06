package emps.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dept.model.DeptDTO;
import dept.service.DeptService;
import emps.model.EmpsDTO;
import emps.model.EmpsDetailDTO;
import emps.service.EmpsService;
import job.model.JobDTO;
import job.service.JobService;

@WebServlet("/emps/add")
@MultipartConfig 
public class EmpsAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view ="/WEB-INF/jsp/emps/add.jsp";
		
		EmpsService empsService = new EmpsService();
		JobService jobService = new JobService();
		DeptService deptService = new DeptService();
		
		List<DeptDTO> deptDatas =deptService.getAll();
		List<JobDTO> jobDatas =jobService.getAll();
		
		request.setAttribute("deptDatas", deptDatas);
		request.setAttribute("jobDatas", jobDatas);
		request.setAttribute("imgPath", empsService.getProfleImagePath(request, "/static/img/emp/", new EmpsDTO()));
		
		
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String empId = request.getParameter("empId");
		String empName = request.getParameter("empName");
		String jobId = request.getParameter("jobId");
		String deptId = request.getParameter("deptId");
		String email = request.getParameter("email");
		String hireDate = request.getParameter("hireDate");;
		String phone = request.getParameter("phone");;
		String salary = request.getParameter("salary");;
		String commission = request.getParameter("commission");;
		
		EmpsDTO empsData = new EmpsDTO();
		empsData.setEmpId(empId);
		empsData.setEmpName(empName);
		empsData.setJobId(jobId);
		empsData.setDeptId(deptId);
		empsData.setEmail(email);
	
		EmpsDetailDTO empsDetailData = new EmpsDetailDTO();
		empsDetailData.setEmpId(empId);
		empsDetailData.setHireDate(hireDate);
		empsDetailData.setPhone(phone);
		empsDetailData.setSalary(salary);
		empsDetailData.setCommission(commission);
		
		
		EmpsService empsService = new EmpsService();
		boolean result =empsService.add(empsData, empsDetailData);
		
		if(result) {
			Part imgFile = request.getPart("uploadImg");
			String originName = imgFile.getSubmittedFileName();
			
			//????????? ????????? ?????? ???????????? ?????? ??? ???
//			if (!originName.endsWith(".png")) {
//				request.setAttribute("imageError","???????????? PNG ????????? ????????? ?????????");
//				doGet(request,response);
//				return;
//			}
			String location = request.getServletContext().getRealPath("/static/img/emp") + "/" + empsData.getEmpId() + ".png";
			if(!originName.isEmpty()) {
				imgFile.write(location);
			}
			//?????? ??????
			response.sendRedirect(request.getContextPath() + "/emps");
			//response.sendRedirect(request.getContextPath() + "/emps/detail?id=" + empsData.getEmpId());
		}else {
			//?????? ??????
			doGet(request, response);
			response.sendRedirect(request.getContextPath() + "/emps/add");

			
		}
	}
}
