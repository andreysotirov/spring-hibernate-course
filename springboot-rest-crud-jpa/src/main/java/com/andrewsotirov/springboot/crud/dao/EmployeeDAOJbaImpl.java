package com.andrewsotirov.springboot.crud.dao;

import com.andrewsotirov.springboot.crud.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJbaImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJbaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query query = entityManager.createQuery("from Employee");

        List<Employee> employees = query.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int id) {
        return null;
    }

    @Override
    public void save(Employee employee) {

    }

    @Override
    public void deleteById(int id) {

    }
}
