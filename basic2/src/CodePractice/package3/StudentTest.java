package CodePractice.package3;

public class StudentTest {

    public static void main(String[] args) {
        Student studentKang = new Student();
        studentKang.studentName = "Kang";

        System.out.println(studentKang.studentName);
        System.out.println(studentKang.getStudentName());
    }
}
