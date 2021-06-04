package com.example.demoapp.dao;

import com.example.demoapp.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeJpaDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;

    @Autowired
    public EmployeeJpaDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    public List<Employee> findAll() {
        //create query
        Query theQuery =
                entityManager.createQuery("from Employee");

        //execute query and get result
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {

        //get employee
        Employee theEmployee = entityManager.find(Employee.class,theId);
        //return employee
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {

        //save or update employee
        Employee dbEmployee = entityManager.merge(theEmployee);
        theEmployee.setId(dbEmployee.getId());
    }

    @Override
    public void deleteById(int theId) {

        //delete object with primery key
        Query theQuery = entityManager.createQuery(
                "delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}

