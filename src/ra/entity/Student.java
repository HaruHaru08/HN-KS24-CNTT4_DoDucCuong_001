package ra.entity;

import java.util.Scanner;

public class Student {
    private String studentId;
    private String studentName;
    private int age;
    private double gpa;

    public Student() {
    }

    public Student(String studentId, String studentName, int age, double gpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.gpa = gpa;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
    public void inputData(Scanner scanner){
        System.out.print("Nhập mã sinh viên: ");
        this.studentId = ValidateStudent.validateID(scanner.nextLine());
        System.out.print("Nhập tên sinh viên: ");
        this.studentName = scanner.nextLine();
        System.out.print("Nhập tuổi sinh viên: ");
        this.age = ValidateStudent.validateage(Integer.parseInt(scanner.nextLine()));
        System.out.print("Nhập điểm GPA: ");
        this.gpa = ValidateStudent.validateGrade(Double.parseDouble(scanner.nextLine()));
    };

    public void displayData() {
        System.out.printf("| %-12s | %-12s | %3d | %5.2f |%n",
                this.studentId,
                this.studentName,
                this.age,
                this.gpa);
    }
}
