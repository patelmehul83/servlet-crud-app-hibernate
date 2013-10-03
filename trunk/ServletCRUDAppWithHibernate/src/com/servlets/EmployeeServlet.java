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

public class EmployeeServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("employeeId"));
		String name = request.getParameter("employeeName");
		double salary = Double.parseDouble(request
				.getParameter("employeeSalary"));

		Employee employee = new EmployeeImpl();
		employee.setId(id);
		employee.setName(name);
		employee.setSalary(salary);

		EmployeeService employeeService = new EmployeeServiceImpl();

		employeeService.create(employee);

		response.sendRedirect("success.html");

	}
}
