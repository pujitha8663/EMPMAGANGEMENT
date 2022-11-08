package com.services;

import java.util.List;

import com.model.Employee;

public interface ServiceDao {
	 public void batch_insertion(List<Employee> emp);
	 void add(Employee employee);
	 void update(double salary, int id);
	 List<Employee> getAllEmpl();
	 public void batch_insert_insertion_delete(List<Employee> insert,List<Employee> delete);
		

}
