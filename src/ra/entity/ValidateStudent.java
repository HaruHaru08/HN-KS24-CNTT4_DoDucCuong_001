package ra.entity;

import java.util.List;

public class ValidateStudent {
    static String STUDENT_ID="^SV\\d{3}$";

    public static String validateID(String id){
        if (id == null || id.trim().isEmpty()) {
            System.out.println("Id không được để trống");
        }
        if(!id.matches(STUDENT_ID)){
            System.out.println("Id không hợp lệ");
        }
        return id;
    }
    public static int validateage(int age){
        if(age<18 || age>100){
            System.out.println("Tuổi không hợp lệ");
        }
        return age;
    }
    public static double validateGrade(double grade){
        if(grade<0.0||grade>10.0){
            System.out.println("GPA không hợp lệ");
        }
        return grade;
    }
    public static void checkUniqueId(String studentId, List<Student> students) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                System.out.println("Id đã tồn tại");
            }
        }
    }
}
