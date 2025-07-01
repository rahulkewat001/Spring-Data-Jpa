package JPA_HIBERNATE.spring.data.jpa.tutorial.repository;

import JPA_HIBERNATE.spring.data.jpa.tutorial.entity.Guardian;
import JPA_HIBERNATE.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("rahul@gmail.com")
                .firstName("Rahul")
                .lastName("Kewat")
//                .guardianName("Ram")
//                .guardianEmail("ram@gmail.com")
//                .guardianMobile("9999999999")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList =
                studentRepository.findAll();
        System.out.println("studentList : " + studentList);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder().
                name("Nikhil")
                .email("nikhil@gmail.com")
                .mobile("9999999405").
                build();

        Student student = Student.builder()
                .firstName("Shyam")
                .lastName("Kumar")
                .emailId("shyam@gmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students =
                studentRepository.findByFirstName("shyam");
        System.out.println("students : " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students =
                studentRepository.findByFirstNameContaining("Ra");
        System.out.println("students : " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students =
                studentRepository.findByGuardianName("Nikhil");
        System.out.println("students : " + students);
    }

    @Test
    public void printStudentBasedOnFirstAndLastName() {
        List<Student> students =
                studentRepository.findByFirstNameAndLastName("Rahul", "Kewat");
        System.out.println("students : " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student =
                studentRepository.getStudentByEmailAddress("shyam@gmail.com");
        System.out.println("student : " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress("rahul@gmail.com");
        System.out.println("student : " + firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative() {
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "rahul@gmail.com"
                );
        System.out.println("student : " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeParam() {
        Student student =
                studentRepository.getStudentByEmailAddressNativeParam(
                        "rahul@gmail.com"
                );
        System.out.println("student : " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("Rudra",
                        "rahul@gmail.com");
    }

}