package in.abhisingh.spring.data.jpa.tutorial.repository;

import in.abhisingh.spring.data.jpa.tutorial.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName, String lastName);

    // JPQL Queries, use JAVA class names and fields name rather than SQL table names.
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    // JPQL Queries, use JAVA class names and fields name rather than SQL table names.
    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    // Using native SQL Queries.
    @Query(nativeQuery = true, value = "select * from tbl_student s where s.email_address = ?1")
    Student getStudentByEmailAddressNative(String emailId);

    // Using native SQL Queries.
    @Query(nativeQuery = true, value = "select s.first_name from tbl_student s where s.email_address = ?1")
    String getStudentFirstNameByEmailAddressNative(String emailId);

    // Using native SQL Queries - with named parameters.
    @Query(nativeQuery = true, value = "select * from tbl_student s where s.email_address = :emailId")
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "update tbl_student set first_name = ?1 where email_address = ?2")
    int updateStudentNameByEmailId(String firstName, String emailId);
}