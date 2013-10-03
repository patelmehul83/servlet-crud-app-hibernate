package com.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.service.EmployeeService;
import com.domain.service.impl.EmployeeServiceImpl;

public class DeleteEmployeeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		EmployeeService employeeService = new EmployeeServiceImpl();

		employeeService.delete(id);

		response.sendRedirect("EmployeeListServlet");

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String[] multipleDel = request.getParameterValues("multipleDel");

		EmployeeService employeeService = new EmployeeServiceImpl();

		for (int i = 0; i < multipleDel.length; i++) {

			employeeService.delete(Integer.parseInt(multipleDel[i]));

		}

		response.sendRedirect("EmployeeListServlet");

	}
}
