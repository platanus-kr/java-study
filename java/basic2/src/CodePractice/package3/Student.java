package CodePractice.package3;

public class Student {

    int studentID;
    String studentName;
    int grade;
    String address;

    public void showStudentInfo() {
        System.out.println(studentName + "," + address);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String name) {
        studentName = name;
    }

    public static void main(String[] args) {
        Student studentKang = new Student();
        studentKang.studentName = "Kang";

        System.out.println(studentKang.studentName);
        System.out.println(studentKang.getStudentName());
    }
}
