package in.abhisingh.spring.data.jpa.tutorial.repository;

import in.abhisingh.spring.data.jpa.tutorial.entity.Course;
import in.abhisingh.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("resist")
                .credit(736)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.google.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

}