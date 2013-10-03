package com.domain.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import com.domain.Employee;
import com.domain.impl.EmployeeImpl;
import com.domain.service.EmployeeService;
import com.utils.HibernateUtil;

public class EmployeeServiceImpl implements EmployeeService {

	private static List<Employee> employeeList = new ArrayList<Employee>();

	@Override
	public void create(Employee employee) {

		Session session = HibernateUtil.getSession();

		try {

			Transaction tx = session.beginTransaction();

			session.saveOrUpdate(employee);

			tx.commit();

		} catch (Exception exception) {

			exception.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		employeeList.add(employee);
	}

	@Override
	public List<Employee> getAll() {

		List<Employee> employeeList = null;
		Session session = HibernateUtil.getSession();

		try {

			Query query = session.getNamedQuery("Employee.findAll");

			employeeList = query.list();

		} catch (Exception ex) {

			ex.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return employeeList;
	}

	@Override
	public void delete(int employeeId) {

		Session session = HibernateUtil.getSession();
		EmployeeImpl employee = null;

		try {

			Transaction tx = session.beginTransaction();
			employee = (EmployeeImpl) session.get(EmployeeImpl.class,
					employeeId);
			if (employee != null) {
				session.delete(employee);
				tx.commit();
			}

		} catch (Exception exception) {

			exception.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public Employee findById(int id) {

		Session session = HibernateUtil.getSession();
		EmployeeImpl employee = null;

		try {

			employee = (EmployeeImpl) session.get(EmployeeImpl.class, id);

		} catch (Exception ex) {

			ex.printStackTrace();

		} finally {

			if (session != null) {
				session.close();
			}
		}
		return employee;
	}
}
