package com.mustafa.springbootrestfulapi.repository;

import com.mustafa.springbootrestfulapi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
