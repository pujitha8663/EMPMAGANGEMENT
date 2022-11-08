package com.Client;

import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.services.ServiceImpl;

public class delete_insert {
	public static void main(String[] args) {
		List<Employee> em =new ArrayList<Employee>();
		List<Employee> del=new ArrayList<Employee>();
		del.add(new Employee(1));
		em.add(new Employee(2, "kiran", 20000));
		//em.add(new Employee(11, "kumar", 100000));
		
		
		
		
		
		
		
		
		ServiceImpl sl = new ServiceImpl();
		
		sl.batch_insert_insertion_delete(em, del);
		
	}

}
