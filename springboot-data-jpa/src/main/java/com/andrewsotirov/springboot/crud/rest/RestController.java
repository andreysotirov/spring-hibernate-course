package com.andrewsotirov.springboot.crud.rest;

import com.andrewsotirov.springboot.crud.Entity.Employee;
import com.andrewsotirov.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    private EmployeeService employeeService;

    @Autowired
    public RestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        if (employee == null) {
            throw new RuntimeException("Employee id not found " + employeeId);
        }
        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(0);
        employeeService.save(employee);

        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.save(employee);
        return employee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {

        Employee employee = employeeService.findById(employeeId);

        employeeService.deleteById(employeeId);
        if (employee == null) {
            throw new RuntimeException("Employee id not found " + employeeId);
        }
        return "Deleted employee ID " + employeeId;
    }
}
