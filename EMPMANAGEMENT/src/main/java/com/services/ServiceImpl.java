package com.services;

import java.util.List;

import com.DAO.EmployeeDAOImpl;
import com.model.Employee;

public class ServiceImpl implements ServiceDao{
	
	 EmployeeDAOImpl impl = new EmployeeDAOImpl();
	public void add(Employee employee) {
		impl.add(employee);
		
	}

	

	public List<Employee> getAllEmpl() {
		// TODO Auto-generated method stub
		return impl.getAllEmployees();
	}



	public void update(double salary, int id) {
		impl.update(salary, id);
		
	}



	public void batch_insertion(List<Employee> emp) {
	impl.batch_insertion(emp);
		
	}



	public void batch_insert_insertion_delete(List<Employee> insert, List<Employee> delete) {
		impl.batch_insert_insertion_delete(insert, delete);
		
	}
	

}
