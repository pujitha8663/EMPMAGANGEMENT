package com.Client;

import java.util.List;

import com.model.Employee;
import com.services.ServiceImpl;

public class EmpCilent {
 public static void main(String[] args) {
	 //Employee employee = new Employee(1,"puja",25000);
	ServiceImpl impl = new ServiceImpl();
	//Employee employee2= new Employee(2,"shan",30000);
	impl.update(45000, 2);
	
	//impl.add(employee2);
	
	
	
//	List<Employee> im = impl.getAllEmpl();
//	for(Employee employee : im) {
//		System.out.println(employee);
	//}
 }
}

