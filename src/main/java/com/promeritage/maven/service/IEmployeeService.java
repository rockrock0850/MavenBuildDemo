package com.promeritage.maven.service;

import java.util.List;

import com.promeritage.maven.common.vo.form.EmployeeVO;
import com.promeritage.maven.entity.Employee;

public interface IEmployeeService {
	public List<Employee> select();
	
	public Employee select(long id);
	
	public Employee insert(EmployeeVO employeeVO);

	public Employee update(EmployeeVO employeeVO);

	public void delete(long id);

}
