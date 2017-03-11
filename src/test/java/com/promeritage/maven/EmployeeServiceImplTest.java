package com.promeritage.maven;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.promeritage.maven.dao.IEmployeeDao;
import com.promeritage.maven.entity.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:configs/config.xml")
public class EmployeeServiceImplTest {
	
	@Autowired
	private IEmployeeDao iEmployeeDao;

	@Test
	@Transactional("transactionManager")
	public void testSelect() {
		Assert.assertNotNull(iEmployeeDao.select());
	}

	@Test
	@Transactional("transactionManager")
	public void testSelectLong() {
		Assert.assertNotNull(iEmployeeDao.select(1));
	}

	@Test
	@Transactional("transactionManager")
	public void testInsert() {
		Employee employee = new Employee();
		employee.setFirstName("testCase");
		employee.setLastName("testCase");
		employee.setBirthDate(new Date());
		employee.setCellPhone("0987654321");
		
		Assert.assertNotNull(iEmployeeDao.insert(employee));
	}

	@Test
	@Transactional("transactionManager")
	public void testUpdate() {
		Employee employee = new Employee();
		employee.setId((long) 2);
		employee.setFirstName("testCase");
		employee.setLastName("testCase");
		employee.setBirthDate(new Date());
		employee.setCellPhone("0987654321");
		
		Assert.assertNotNull(iEmployeeDao.update(employee));
	}

	@Test
	@Transactional("transactionManager")
	public void testDelete() {
		Assert.assertNotNull(iEmployeeDao.delete(99999));
	}

}
