package com.electro.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electro.user.entity.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}