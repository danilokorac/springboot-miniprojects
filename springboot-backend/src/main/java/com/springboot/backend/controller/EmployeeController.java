package com.springboot.backend.controller;

import com.springboot.backend.model.Employee;
import com.springboot.backend.service.EmployeeService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// @RequestBody annotation allows us to retrieve the request's body and automatically convert it to Java Object
// ResponseEntity class is used to prefer response of the rest api.

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    // build create employee REST API
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    // build get all employees REST EPI
    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployee();
    }

    // build get employees by id REST API
    // http://localhost:8080/api/employees/1 -- id is dynamic so we can pass any id, so thats why is getmapping definde like that
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeesById(@PathVariable("id") long employeeId){
        return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeId), HttpStatus.OK);
    }

    // build update employees REST EPI
    // http://localhost:8080/api/employees/1
    @PutMapping("{id}") // Used to update/modify the resource, thats why we use it here.
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long employeeId, @RequestBody Employee employee){
        return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, employeeId), HttpStatus.OK);
    }

    // build delete employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){

        // delete's employee from database
        employeeService.deleteEmployee(id);

        return new ResponseEntity<String>("Employee deleted successfully!", HttpStatus.OK);
    }
}
