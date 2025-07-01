package JPA_HIBERNATE.spring.data.jpa.tutorial.repository;

import JPA_HIBERNATE.spring.data.jpa.tutorial.entity.Course;
import JPA_HIBERNATE.spring.data.jpa.tutorial.entity.Student;
import JPA_HIBERNATE.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse() {
        List<Course> courses =
                courseRepository.findAll();
        System.out.println("Courses" + courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Harry")
                .lastName("Bhai")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(7)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination() {
        Pageable firstPageWithThreeRecords =
                PageRequest.of(0, 3);
        Pageable secondPageWithTwoRecords =
                PageRequest.of(1, 2);

        List<Course> courses =
                courseRepository.findAll(secondPageWithTwoRecords)
                        .getContent();

        long totalElements =
                courseRepository.findAll(secondPageWithTwoRecords)
                                .getTotalElements();

        long totalPages =
                courseRepository.findAll(secondPageWithTwoRecords)
                .getTotalPages();

        System.out.println("Total Pages: " + totalPages);

        System.out.println("Total elements: " + totalElements);

        System.out.println("Courses" + courses);

    }

    @Test
    public void findAllSorting() {
        Pageable sortByTitle =
                PageRequest.of(0, 2,
                        Sort.by("title").descending());

        Pageable sortByCreditDesc =
                PageRequest.of(0, 2,
                        Sort.by("credit").descending());

        Pageable sortByTitleAndCreditDesc =
                PageRequest.of(0, 2,
                        Sort.by("title").descending()
                                .and(Sort.by("credit")));

        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Courses" + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Lizza")
                .lastName("Moragn")
                .build();

        Student student = Student.builder()
                .firstName("Arjun")
                .lastName("Singh")
                .emailId("arjun@gmail.com")
                .build();

        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();
        course.addStudents(student);

        courseRepository.save(course);

    }
}