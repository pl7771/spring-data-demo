package com.ilya.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.ilya.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	public EmployeeDAOJpaImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		//create query
		Query query = entityManager.createQuery("from Employee");
		//execute query
		List<Employee> employees = query.getResultList();
		//return results
		return employees;
	}

	@Override
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmpl = entityManager.merge(employee);
		employee.setId(dbEmpl.getId());
	}

	@Override
	public void deleteById(int id) {
		Query query = entityManager.createQuery("delete from Employee where id=:emplId");
		query.setParameter("emplId", id);
		query.executeUpdate();
	}

}
