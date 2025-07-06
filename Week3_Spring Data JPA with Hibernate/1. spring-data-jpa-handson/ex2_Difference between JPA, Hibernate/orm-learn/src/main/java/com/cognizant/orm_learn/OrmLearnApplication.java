package com.cognizant.orm_learn;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cognizant.orm_learn.hibernate.EmployeeHibernateDao;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.service.EmployeeService;



@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static EmployeeService employeeService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        employeeService = context.getBean(EmployeeService.class);
        testSpringDataJpaAdd();
        testHibernateAdd();
    }

    private static void testSpringDataJpaAdd() {
        LOGGER.info("Spring Data JPA - Add Employee");
        Employee emp = new Employee("Spring Bob", 65000);
        employeeService.addEmployee(emp);
        LOGGER.debug("Saved via Spring Data JPA: {}", emp);
    }

    private static void testHibernateAdd() {
        LOGGER.info("Hibernate - Add Employee");
        Employee emp = new Employee("Hibernate Alice", 55000);
        EmployeeHibernateDao dao = new EmployeeHibernateDao();
        dao.addEmployee(emp);
        LOGGER.debug("Saved via Hibernate with ID: {}", emp.getId());
    }
}

