/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.employeemanagementsystem.service;

/**
 *
 * @author Ashwithaa
 */
import com.mycompany.employeemanagementsystem.Employee;
import com.mycompany.employeemanagementsystem.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

//    @Autowired
//    private EmployeeRepository employeeRepository;
//
//    public Page<Employee> getEmployeesByName(String name, Pageable pageable) {
//        return employeeRepository.findByName(name, pageable);
//    }
//
//    public Page<Employee> getEmployeesByDepartmentId(Long departmentId, Pageable pageable) {
//        return employeeRepository.findByDepartmentId(departmentId, pageable);
//    }
//      private EmployeeRepository employeeRepository;
//
//    public Page<Employee> getEmployeesByName(String name, Pageable pageable) {
//        return employeeRepository.findByName(name, pageable);
//    }
//
//    public Page<Employee> getEmployeesByDepartmentId(Long departmentId, Pageable pageable) {
//        return employeeRepository.findByDepartmentId(departmentId, pageable);
//    }
//
//    public void deleteEmployee(Long id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public Employee saveEmployee(Employee employee) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public Employee getEmployeeById(Long id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    public List<Employee> getAllEmployees() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
     @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Get paginated and sorted list of employees by their name.
     * 
     * @param name the name of the employee to search for
     * @param pageable the pagination and sorting information
     * @return a page of employees matching the name
     */
    public Page<Employee> getEmployeesByName(String name, Pageable pageable) {
        return employeeRepository.findByName(name, pageable);
    }

    /**
     * Get paginated and sorted list of employees by their department ID.
     * 
     * @param departmentId the ID of the department to filter employees by
     * @param pageable the pagination and sorting information
     * @return a page of employees belonging to the specified department
     */
    public Page<Employee> getEmployeesByDepartmentId(Long departmentId, Pageable pageable) {
        return employeeRepository.findByDepartmentId(departmentId, pageable);
    }
     @Autowired
    private EntityManager entityManager;

    @Transactional
    public void batchInsertEmployees(List<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            entityManager.persist(employees.get(i));
            if (i % 20 == 0) { // Flush and clear every 20 inserts
                entityManager.flush();
                entityManager.clear();
            }
        }
    
    }
}  