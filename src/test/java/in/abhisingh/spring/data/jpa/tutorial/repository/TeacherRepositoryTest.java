package in.abhisingh.spring.data.jpa.tutorial.repository;

import in.abhisingh.spring.data.jpa.tutorial.entity.Course;
import in.abhisingh.spring.data.jpa.tutorial.entity.Teacher;
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
                .credit(454)
                .build();

        Course courseJAVA = Course.builder()
                .title("JAVA")
                .credit(625)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Qutub")
                .lastname("Khan")
                // .courses(List.of(courseDBA, courseJAVA)) // Going for ManyToOne rather than OneToMany.
                .build();

        teacherRepository.save(teacher);
    }
}