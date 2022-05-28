package in.abhisingh.spring.data.jpa.tutorial.repository;

import in.abhisingh.spring.data.jpa.tutorial.entity.Guardian;
import in.abhisingh.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("hammer@gmail.com")
                .firstName("Abhishek")
                .lastName("Singh")
                // .guardianName("Anil")
                // .guardianEmail("anil@gmail.com")
                // .guardianMobile("1234567890")
                .build();

        // studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Anil")
                .email("anil@gmail.com")
                .mobile("1234567890")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("pocket@gmail.com")
                .lastName("kumar")
                .guardian(guardian)
                .build();

        // studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("shivam");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("sh");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = studentRepository.findByGuardianName("Anil");
        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student studentByEmailAddress = studentRepository.getStudentByEmailAddress("shivam3@gmail.com");
        System.out.println("studentByEmailAddress = " + studentByEmailAddress);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String studentFirstNameByEmailAddress = studentRepository.getStudentFirstNameByEmailAddress("shivam3@gmail.com");
        System.out.println("studentFirstNameByEmailAddress = " + studentFirstNameByEmailAddress);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Student studentByEmailAddressNative = studentRepository.getStudentByEmailAddressNative("shivam3@gmail.com");
        System.out.println("studentByEmailAddressNative = " + studentByEmailAddressNative);
    }

    @Test
    public void printStudentFirstNameByEmailAddressNative() {
        String studentFirstNameByEmailAddressNative = studentRepository.getStudentFirstNameByEmailAddressNative("shivam3@gmail.com");
        System.out.println("studentFirstNameByEmailAddressNative = " + studentFirstNameByEmailAddressNative);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Student studentByEmailAddressNativeNamedParam = studentRepository.getStudentByEmailAddressNativeNamedParam("shivam3@gmail.com");
        System.out.println("studentByEmailAddressNativeNamedParam = " + studentByEmailAddressNativeNamedParam);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("Vicky", "abhishek@gmail.com");
    }
}