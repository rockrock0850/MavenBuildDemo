package com.promeritage.maven.dao;

import java.util.List;

import com.promeritage.maven.entity.Employee;

public interface IEmployeeDao {
	
	public List<Employee> select();

	public Employee select(long id);
	
	public Employee insert(Employee employee);

	public Employee update(Employee employee);

	public boolean delete(long id);
	
}