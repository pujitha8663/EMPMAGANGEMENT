package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Employee;
import com.queries.Empqueries;
import com.util.UtilConnections;

public class EmployeeDAOImpl  implements EmpDao{
	

	public void add(Employee employee) {
	Connection connection=null;
	PreparedStatement ps=null;
	
	connection=UtilConnections.getConnection();
	try {
		ps=connection.prepareStatement(Empqueries.INSERT_EMP);
		ps.setInt(1, employee.getEmpId());
		ps.setString(2, employee.getEmpName());
		ps.setDouble(3, employee.getEmpSalary());
		ps.execute();
		System.out.println("success");
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		UtilConnections.close(ps);
	}
	}



	public List<Employee> getAllEmployees() {
		Connection connection = null;
		ResultSet result = null;
		PreparedStatement ps=null;
		List<Employee> empl= new ArrayList<Employee>();
		connection = UtilConnections.getConnection();
		try {
			ps=connection.prepareStatement(Empqueries.SELECT_EMP);
			result=ps.executeQuery();
			Employee e = new Employee();
			while(result.next()) {
				e.setEmpId(result.getInt(1));
				e.setEmpName(result.getString(2));
				e.setEmpSalary(result.getDouble(3));
				empl.add(e);
		} 
			
			return empl;
			
		}catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		finally {
			UtilConnections.close(result,ps);
		}
		
		return null;
	}



	public void update(double salary, int id) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps= null;
		connection= UtilConnections.getConnection();
		try {
			
			
			ps=connection.prepareStatement(Empqueries.UPDATE_SALARY_WITH_ID);
		
			ps.setDouble(1, salary);
			ps.setInt(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}



	public void batch_insertion(List<Employee> emp)  {
		Connection connection = null;
		PreparedStatement pr = null;
		connection= UtilConnections.getConnection();
		
		try {
			connection.setAutoCommit(false);
			pr= connection.prepareStatement("insert into employees values(?,?,?) ");
			for (Employee employee : emp) {
				
			
				pr.setString(2, employee.getEmpName());
				pr.setInt(1, employee.getEmpId());
				pr.setDouble(3, employee.getEmpSalary());
			pr.execute();
			
				}
			System.out.println("success");
			connection.commit();
			
			
		} catch (SQLException e) {
			try {
				System.out.println(e.getMessage());
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		finally {
			try {
				connection.close();
				pr.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}



	public void batch_insert_insertion_delete(List<Employee> insert, List<Employee> delete) {
		Connection connection=null;
		PreparedStatement ps= null;
		PreparedStatement del = null;
		connection=UtilConnections.getConnection();
		try {
			ps=connection.prepareStatement(Empqueries.INSERT_EMP);
			del=connection.prepareStatement(Empqueries.DELETE_WITH_ID);
			connection.setAutoCommit(false);
			for (Employee employee : insert) {
				
				ps.setString(2, employee.getEmpName() );
				ps.setInt(1, employee.getEmpId());
				ps.setDouble(3, employee.getEmpSalary());
				ps.execute();
			}
			
			for (Employee employee : delete) {
				del.setInt(1, employee.getEmpId());
				del.execute();
				
			}
			connection.commit();
			System.out.println("Transaction Sucesss...");
			
		} catch (SQLException e) {
			try {
				connection.rollback();
				System.out.println(e.getMessage());
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		finally {
			try {
				connection.close();
				ps.close();
				del.close();
				
			} 
		
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}

}
