package ra.presentation;

import ra.business.StudentBusiness;
import ra.entity.Student;
import ra.entity.ValidateStudent;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentBusiness studentBusiness =new StudentBusiness();
        int choice;
        do{
            System.out.println("******************** QUẢN LÝ SINH VIÊN *********************");
            System.out.println("1.Hiện thị danh sách toàn bộ sinh viên");
            System.out.println("2.Thêm mới sinh viên");
            System.out.println("3.Cập nhập thông tin sinh viên theo mã sinh viên");
            System.out.println("4.Xóa sinh viên theo mã sinh viên");
            System.out.println("5.Tìm kiếm sinh viên theo tên");
            System.out.println("6.Lọc danh sách sinh viên Giỏi");
            System.out.println("7.Sắp xếp danh sách sinh viên giảm dần theo điểm");
            System.out.println("8.Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    studentBusiness.listAllStudents();
                    break;
                case 2:
                    while (true){
                        var student = new ra.entity.Student();
                        student.inputData(sc);
                        studentBusiness.addStudent(student);
                        System.out.println("Thêm sinh viên thành công.");
                        System.out.print("Có muốn tiếp tục thêm không? (y/n): ");
                        String continueInput = sc.nextLine();
                        if (!continueInput.equalsIgnoreCase("y")) {
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã sinh viên muốn sửa: ");
                    String id = sc.nextLine();
                    Optional<Student> studentOpt = studentBusiness.findStudentById(id);
                    if (studentOpt.isPresent()) {
                        studentBusiness.updateStudent(studentOpt.get(), sc);
                        System.out.println("Cập nhập sinh viên thành công.");
                    } else {
                        System.out.println("Cập nhập sinh viên thất bại.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã sinh viên muốn xóa: ");
                    String idRemove=sc.nextLine();
                    studentBusiness.deleteStudent(idRemove);
                    break;
                case 5:
                    System.out.print("Nhập tên sinh viên muốn tìm: ");
                    break;
                case 6:
                    System.out.print("Danh sách sinh viên Giỏi: ");
                    studentBusiness.filterStudentsByGpa();
                    break;
                case 7:
                    break;
                case 8:
                    System.out.println("Chương trình kết thúc");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        }while (choice!=8);
    }
}
