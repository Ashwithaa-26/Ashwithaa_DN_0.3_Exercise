/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mcvpattern;

/**
 *
 * @author Ashwithaa 
 */
public class MCVPattern { 

    public static void main(String[] args) {
// Create a student record
        Student model = retrieveStudentFromDatabase();

        // Create MCa view to display student details
        StudentView view = new StudentView();

        // Create a controller
        StuudentController controller = new StuudentController(model, view);

        // Display initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("John Doe");
        controller.setStudentGrade("A");

        // Display updated student details
        controller.updateView();
    }

    private static Student retrieveStudentFromDatabase() {
        Student student = new Student();
        student.setId("1");
        student.setName("Jane Smith");
        student.setGrade("B");
        return student;    }
}
