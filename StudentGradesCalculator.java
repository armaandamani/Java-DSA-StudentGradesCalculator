/**
 * StudentGradesCalculator.java: Java program that collects and displays the average grades of students in a class.
 * 
 * @author Armaan Damani
 * @version 1.0
 */

import java.util.Scanner;

public class StudentGradesCalculator {

    // Inner class (Student)
    static class Student {
        String name;
        int[] grades;

        public Student(String name, int[] grades) {
            this.name = name;
            this.grades = grades;
        }

        public double getAverageGrade() {
            int total = 0;
            for (int grade : grades) {
                total += grade;
            }
            double average = (double) total / grades.length;
            return average;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        final int NUM_OF_STUDENTS = 3;
        final int NUM_OF_SUBJECTS = 3;

        Student[] students = new Student[NUM_OF_STUDENTS]; 
        double totalClass = 0.0;
        
        // First loop is for data input, gathering each student's name and grades
        for (int i = 0; i < NUM_OF_STUDENTS; i++) {
            System.out.println("Student " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = input.nextLine();

            int[] grades = new int[NUM_OF_SUBJECTS]; // Creates a new array to store the grades from each student
            System.out.println("Enter " + NUM_OF_SUBJECTS + " grades:");
            for (int j = 0; j < NUM_OF_SUBJECTS; j++) {
                grades[j] = input.nextInt();
            }
            input.nextLine();

            students[i] = new Student(name, grades); // Creating new student objects and storing in array
            System.out.println();
        }

        // Second loop is for calculating the average grade for each student, and displaying results
        for (int i = 0; i < NUM_OF_STUDENTS; i++) {
            Student student = students[i];
            double avg = student.getAverageGrade();
            totalClass += avg;

            // Display each student's name and grade...
            System.out.println("Student " + (i + 1) + ":"); 
            System.out.println("Name: " + student.name);
            System.out.print("Grades: ");
            for (int grade : student.grades) {
                System.out.print(grade + " ");
            }
            System.out.printf("%nAverage Grade: %.2f%n", avg);
            System.out.println();
        }

        // Calculate and display class average
        double classAverage = totalClass / NUM_OF_STUDENTS;
        System.out.printf("Class Average Grade: %.2f%n", classAverage);

        input.close();
    }
}
