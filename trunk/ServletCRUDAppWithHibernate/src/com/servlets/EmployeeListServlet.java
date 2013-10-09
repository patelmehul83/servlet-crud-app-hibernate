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
			out.println("<p align = 'center'><font size = '5' color='white'>Employee Details</font></p><br>");

			out.println("<form method='POST' action='DeleteEmployeeServlet'>");
			out.println("<table bgcolor='pink' align='center' cellpadding='15'>");
			out.println("</form>");

			out.println("<tr><td><input type='submit' value='delete'></td>");
			out.println("<form method='POST' action ='EmployeeListServlet'>");
			out.println("<td><input type='text' name = 'searchId' value='Enter Id' size='8'><input type='submit' value='Search'></td></tr>");
			out.println("</form>");
			out.println("<th></th><th>ID</th>");
			out.println("<th>NAME</th>");
			out.println("<th>SALARY</th>");
			out.println("<th> ACTION </th>");

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

			out.println("</table>");

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

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("searchId"));

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
			out.println("<head><title>Employee List</title>");
			out.println("<link rel = 'stylesheet' type='text/css' href='css/mycss.css'></head>");

			out.println("<body>");

			out.println("<h1 align = 'center'>Servlet CRUD App</h1><hr/><br>");
			out.println("<p align = 'center'><font size = '5' color='white'>Employee Details</font></p><br>");

			out.println("<table bgcolor='pink' align='center' cellpadding='15'>");

			out.println("<th>ID</th>");
			out.println("<th>NAME</th>");
			out.println("<th>SALARY</th>");

			out.println("<tr>");
			out.println("<td>" + employee.getId() + "</td>");
			out.println("<td>" + employee.getName() + "</td>");
			out.println("<td>" + employee.getSalary() + "</td>");
			out.println("</tr>");

			out.println("</table>");
			out.println("<p align='center'>| <a href='EmployeeListServlet'>List Employees</a> | <a href='index.html'>HOME</a> | <a href='createEmployee.html'>ADD MORE</a> |</p>");
			out.println("</body>");
			out.println("</html>");

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (out != null) {
				out.close();
			}
		}

	}
}
