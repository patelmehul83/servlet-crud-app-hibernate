package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Employee;
import com.domain.service.EmployeeService;
import com.domain.service.impl.EmployeeServiceImpl;

public class EmployeeListServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EmployeeService employeeService = new EmployeeServiceImpl();

		response.setContentType("text/html");

		PrintWriter out = null;

		try {

			out = response.getWriter();

			out.println("<html>");
			out.println("<head><title>Employee List</title>");
			out.println("<link rel = 'stylesheet' type='text/css' href='css/mycss.css'></head>");

			out.println("<body>");

			out.println("<h1 align = 'center'>Servlet CRUD App</h1><hr/><br>");

			out.println("<form method='POST' action='DeleteEmployeeServlet'>");
			out.println("<table bgcolor='pink' align='center' cellpadding='15'>");

			out.println("<th></th><th> EMPLOYEE ID  </th>");
			out.println("<th> EMPLOYEE NAME  </th>");
			out.println("<th> EMPLOYEE SALARY  </th>");
			out.println("<th> ACTION  </th>");

			List<Employee> employeeList = employeeService.getAll();

			for (int i = 0; i < employeeList.size(); i++) {

				out.println("<tr>");
				out.println("<td><input type='checkbox' name='multipleDel' value ="
						+ employeeList.get(i).getId() + "></td>");
				out.println("<td>" + employeeList.get(i).getId() + "</td>");
				out.println("<td>" + employeeList.get(i).getName() + "</td>");
				out.println("<td>" + employeeList.get(i).getSalary() + "</td>");
				out.println("<td><a href=DeleteEmployeeServlet?id="
						+ employeeList.get(i).getId() + ">Delete</a></td>");
				out.println("<td><a href=UpdateEmployeeServlet?id="
						+ employeeList.get(i).getId() + ">Edit</a></td>");
				out.println("</tr>");

			}

			out.println("<tr><td><input type='submit' value='delete'></td></tr>");
			out.println("</table>");
			out.println("</form>");
			out.println("<p align='center'>| <a href='index.html'>HOME</a> | | <a href='createEmployee.html'>ADD MORE</a> |</p>");
			out.println("</body>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			if (out != null) {
				out.close();
			}
		}

	}
}
