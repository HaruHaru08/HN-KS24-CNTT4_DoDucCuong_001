package ra.business;

import ra.entity.Student;
import ra.entity.ValidateStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentBusiness {
    private static StudentBusiness instance;

    public static StudentBusiness getInstance() {
        if (instance == null) {
            instance = new StudentBusiness();
        }
        return instance;
    }
    private List<Student> students = new ArrayList<>();
    public void listAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            showStudentsTable(students);
        }
    }
    public void showStudentsTable(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.printf("| %-12s | %-12s | %3s | %-5s |%n",
                    "Student ID", "Name", "Age", "GPA");
            System.out.println("------------------------------------------");
            for (Student student : students) {
                student.displayData();
            }
        }
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public List<Student> findStudentsByName(String name) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }
    public Optional<Student> findStudentById(String studentId) {
        return students.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst();
    }

    public void updateStudent(Student student, Scanner scanner) {
        findStudentById(student.getStudentId()).ifPresent(existingStudent -> {
            interactivelyUpdateStudent(scanner, existingStudent);
        });
    }

    public void deleteStudent(String studentId) {
        if (!students.removeIf(s -> s.getStudentId().equals(studentId))) {
            System.out.println("Id không tồn tại");
        }
    }
    public void sortStudents(){
        students.sort((v1,v2)->Double.compare(v2.getGpa(),v1.getGpa()));
    }
    public void filterStudentsByGpa() {
    List<Student> filteredStudents = new ArrayList<>();
    for (Student student : students) {
        if (student.getGpa() >= 8.0) {
            filteredStudents.add(student);
        }
    }
    showStudentsTable(filteredStudents);
}

    static void interactivelyUpdateStudent(Scanner scanner, Student student) {
        System.out.println("Cập nhật sinh viên với ID: " + student.getStudentId());

        System.out.print("Nhập tên mới (để trống nếu muốn giữ nguyên): ");
        String newName = scanner.nextLine();
        if (!newName.trim().isEmpty()) {
            student.setStudentName(newName);
        }

        System.out.print("Nhập tuổi mới (để trống nếu muốn giữ nguyên): ");
        String ageInput = scanner.nextLine();
        if (!ageInput.trim().isEmpty()) {
            student.setAge(ValidateStudent.validateage(Integer.parseInt(ageInput)));
        }

        System.out.print("Nhập GPA mới (để trống nếu muốn giữ nguyên): ");
        String gpaInput = scanner.nextLine();
        if (!gpaInput.trim().isEmpty()) {
            student.setGpa(ValidateStudent.validateGrade(Double.parseDouble(gpaInput)));
        }
    }
}
