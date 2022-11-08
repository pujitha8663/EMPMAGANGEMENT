package com.Client;

import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.services.ServiceImpl;

public class emp_batch_insertion {
    public static void main(String[] args) {
		List<Employee> emp=new ArrayList<Employee>();
		emp.add(new Employee(6, "sriman", 50000));
		emp.add(new Employee(5, "pavan", 30000));
		emp.add(new Employee(7, "mahesh", 25000));
		
		ServiceImpl sl = new ServiceImpl();
		sl.batch_insertion(emp);
		 
    	
    	
	}
	
	
	
}
