package com.queries;

public interface Empqueries {
	public static String SELECT_EMP="SELECT *FROM EMPLOYEES";
	public static String INSERT_EMP="insert into employees values(?,?,?)";
	public static String UPDATE_SALARY_WITH_ID="update employees set empsalary=? where empid=?";
	public static String DELETE_WITH_ID="DELETE FROM EMPLOYEES WHERE EmpID=?";

}
