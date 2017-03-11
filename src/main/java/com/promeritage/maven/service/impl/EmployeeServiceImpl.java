package com.promeritage.maven.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promeritage.maven.common.utils.Constant;
import com.promeritage.maven.common.utils.ShareTool;
import com.promeritage.maven.common.vo.form.EmployeeVO;
import com.promeritage.maven.dao.IEmployeeDao;
import com.promeritage.maven.entity.Employee;
import com.promeritage.maven.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	
	private Logger log = Logger.getLogger(this.getClass());
	
	@Autowired
    private IEmployeeDao employeeDao;

	@Override
	@Transactional("transactionManager")
	public List<Employee> select() {
		try {
			List<Employee> list = employeeDao.select();

			return list.size() > 0 ? list : null; 
		} catch (Exception e) {
			log.error(e, e);
		}
		
		return null;
	}

	@Override
	@Transactional("transactionManager")
	public Employee select(long id) {
		try {
			Employee employee = employeeDao.select(id);
			
			return employee == null ? null : employee;	
		} catch (Exception e) {
			log.error(e, e);
		}
		
		return null;
	}

	@Override
	@Transactional("transactionManager")
	public Employee insert(EmployeeVO employeeVO) {
		try {
			Employee employee = new Employee();
			employee.setFirstName(employeeVO.getFirstName());
			employee.setLastName(employeeVO.getLastName());
			employee.setCellPhone(employeeVO.getCellPhone());
			employee.setBirthDate(ShareTool.toDate(employeeVO.getBirthDate(), Constant.DATE_PATTERN1));
			
			employee = employeeDao.insert(employee);
			
			return employee == null ? null : employee;
		} catch (Exception e) {
			log.error(e, e);
		}
		
		return null;
	}

	@Override
	@Transactional("transactionManager")
	public Employee update(EmployeeVO employeeVO) {
		try {
			Employee employee = new Employee();
			employee.setId(employeeVO.getId());
			employee.setFirstName(employeeVO.getFirstName());
			employee.setLastName(employeeVO.getLastName());
			employee.setCellPhone(employeeVO.getCellPhone());
			employee.setBirthDate(ShareTool.toDate(employeeVO.getBirthDate(), Constant.DATE_PATTERN1));
			
			employee = employeeDao.update(employee);
			
			return employee == null ? null : employee;	
		} catch (Exception e) {
			log.error(e, e);
		}
		
		return null;
	}

	@Override
	@Transactional("transactionManager")
	public void delete(long id) {
		employeeDao.delete(id);
	}
	
}
