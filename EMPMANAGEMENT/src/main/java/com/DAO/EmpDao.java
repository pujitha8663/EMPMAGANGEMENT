package com.DAO;



import java.util.List;

import com.model.Employee;

public interface EmpDao {
	public void batch_insertion(List<Employee> emp);
	public void add(Employee employee);
	public void update(double salary,int id);
	java.util.List<Employee>getAllEmployees();
	public void batch_insert_insertion_delete(List<Employee> insert,List<Employee> delete);
	
	

}
