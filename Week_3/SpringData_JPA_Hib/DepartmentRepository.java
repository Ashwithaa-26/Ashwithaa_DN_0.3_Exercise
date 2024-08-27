/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.employeemanagementsystem.repository.primary;
import com.mycompany.employeemanagementsystem.secondary.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Ashwithaa
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
