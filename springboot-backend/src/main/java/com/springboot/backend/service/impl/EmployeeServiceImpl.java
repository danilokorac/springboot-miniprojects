package com.springboot.backend.service.impl;

import com.springboot.backend.exception.ResourceNotFoundException;
import com.springboot.backend.model.Employee;
import com.springboot.backend.repository.EmployeeRepository;
import com.springboot.backend.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Two types of dependency injection
// Setter-based dependency injection - used when parameters are mandatory
// Constructor-based dependency injection - used when parameters are optional
// No need for @Transaction, because Spring Data JPA internally provides it


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    // No need for @Autowired, Spring Boot will automatically autowire it when it sees that bean has only one constructor
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }



    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long id) {

//        Optional<Employee> employee = employeeRepository.findById(id);
//
//        if(employee.isPresent()){
//            return employee.get(); // get returns content of optional object
//        }
//        else {
//            throw new ResourceNotFoundException("Employee", "Id", id);
//        }


        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Employee", "Id", id));

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        // Check if employee with given id exists in database
        Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "Id", id));

        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail((employee.getEmail()));

        // Save existing employee to database
        employeeRepository.save(existingEmployee);

        return existingEmployee;
    }

    @Override
    public void deleteEmployee(long id) {

        // Check if employee exists in database or not.
        employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee", "Id", id));
        employeeRepository.deleteById(id);
    }
}
