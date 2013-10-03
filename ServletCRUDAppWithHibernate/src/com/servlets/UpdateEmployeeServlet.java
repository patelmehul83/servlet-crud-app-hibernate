package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Employee;
import com.domain.impl.EmployeeImpl;
import com.domain.service.EmployeeService;
import com.domain.service.impl.EmployeeServiceImpl;

public class UpdateEmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeService employeeService = new EmployeeServiceImpl();

		Employee employee = employeeService.findById(id);

		if (employee == null) {
			return;
		}

		response.setContentType("text/html");
		PrintWriter out = null;

		try {

			out = response.getWriter();

			out.println("<html>");

			out.println("<head>");
			out.println("<title>App | UPDATE </title>");
			out.println("<link rel = 'stylesheet' type = 'text/css' href='css/mycss.css'>");
			out.println("</head>");

			out.println("<h1 align = 'center'>Servlet CRUD App</h1><hr /><br>");

			out.println("<form method='POST'action ='UpdateEmployeeServlet'>");
			out.println("<table cellpadding = '20' align='center' bgcolor='pink'>");

			out.println("<tr>");
			out.println("<td>Employee Id</td>");
			out.println("<td><input type = 'text' name ='empId' readonly = 'true' value="
					+ employee.getId() + "></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Employee Name</td>");
			out.println("<td><input type = 'text' name ='empName' value = "
					+ employee.getName() + "></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td>Employee Salary</td>");
			out.println("<td><input type = 'text' name ='empSal' value = "
					+ employee.getSalary() + "></td>");
			out.println("</tr>");

			out.println("<tr>");
			out.println("<td></td>");
			out.println("<td><input type = 'submit' value = 'update' ></td>");
			out.println("</tr>");

			out.println("</table>");
			out.println("</form>");
			out.println("<p align='center'>| <a href='index.html'>HOME</a> |</p>");
			out.println("</html>");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (out != null) {

				out.close();
			}

		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("empId"));
		String name = request.getParameter("empName");
		Double salary = Double.parseDouble(request.getParameter("empSal"));

		Employee employee = new EmployeeImpl();

		employee.setId(id);
		employee.setName(name);
		employee.setSalary(salary);

		EmployeeService employeeService = new EmployeeServiceImpl();

		employeeService.create(employee);

		response.sendRedirect("EmployeeListServlet");

	}

}
