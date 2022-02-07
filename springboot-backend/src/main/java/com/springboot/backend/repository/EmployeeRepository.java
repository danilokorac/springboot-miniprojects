package com.springboot.backend.repository;

import com.springboot.backend.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository not needed Spring Data JPA already did that
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
