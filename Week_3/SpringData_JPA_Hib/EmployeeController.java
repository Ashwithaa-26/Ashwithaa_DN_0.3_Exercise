/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeemanagementsystem.controller;

/**
 *
 * @author Ashwithaa
 */
import com.mycompany.employeemanagementsystem.Employee;
import com.mycompany.employeemanagementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Sort;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
@RestController
@RequestMapping("/employees")
public class EmployeeController {
// @Autowired
//    private EmployeeService employeeService;
//
//    // Create a new Employee
//    @PostMapping
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeService.saveEmployee(employee);
//    }
//
//    // Get all Employees
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    // Get an Employee by ID
//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable Long id) {
//        return employeeService.getEmployeeById(id);
//    }
//
//    // Update an Employee
//    @PutMapping("/{id}")
//    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
//        employee.setId(id);
//        return employeeService.saveEmployee(employee);
//    }
//
//    // Delete an Employee
//    @DeleteMapping("/{id}")
//    public void deleteEmployee(@PathVariable Long id) {
//        employeeService.deleteEmployee(id);
//    }
//        @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public Page<Employee> getEmployeesByName(String name, Pageable pageable) {
//        return employeeRepository.findByName(name, pageable);
//    }
//
//    public Page<Employee> getEmployeesByDepartmentId(Long departmentId, Pageable pageable) {
//        return employeeRepository.findByDepartmentId(departmentId, pageable);
//    }
     @Autowired
    private EmployeeService employeeService;

    /**
     * Get paginated and sorted list of employees.
     * 
     * @param name optional parameter to filter employees by name
     * @param pageable the pagination and sorting information
     * @return a page of employees matching the search criteria
     */
    @GetMapping
    public Page<Employee> getAllEmployees(
            @RequestParam(required = false) String name,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        if (name != null) {
            return employeeService.getEmployeesByName(name, pageable);
        }
        return employeeService.getEmployeesByDepartmentId(null, pageable);
    }

    /**
     * Get paginated and sorted list of employees by department ID.
     * 
     * @param departmentId the ID of the department to filter employees by
     * @param pageable the pagination and sorting information
     * @return a page of employees belonging to the specified department
     */
    @GetMapping("/department/{departmentId}")
    public Page<Employee> getEmployeesByDepartment(
            @PathVariable Long departmentId,
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
        return employeeService.getEmployeesByDepartmentId(departmentId, pageable);
    }
      @PostMapping("/batchInsert")
    public void batchInsertEmployees(@RequestBody List<Employee> employees) {
        employeeService.batchInsertEmployees(employees);
    }
}
