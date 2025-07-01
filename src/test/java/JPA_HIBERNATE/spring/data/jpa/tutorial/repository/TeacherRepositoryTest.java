package JPA_HIBERNATE.spring.data.jpa.tutorial.repository;

import JPA_HIBERNATE.spring.data.jpa.tutorial.entity.Course;
import JPA_HIBERNATE.spring.data.jpa.tutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();

        Course courseJava = Course.builder()
                .title("Java")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Kumal")
                .lastName("Kushwaha")
//                .courses(List.of(courseDBA, courseJava))
                .build();
        teacherRepository.save(teacher);
    }

}