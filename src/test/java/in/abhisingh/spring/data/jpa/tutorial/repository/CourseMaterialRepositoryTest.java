package in.abhisingh.spring.data.jpa.tutorial.repository;

import in.abhisingh.spring.data.jpa.tutorial.entity.Course;
import in.abhisingh.spring.data.jpa.tutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void saveCourseMaterial() {

        Course course = Course.builder()
                .title("ability")
                .credit(856)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.wind.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = repository.findAll();
        System.out.println("courseMaterials = " + courseMaterials);
    }

}