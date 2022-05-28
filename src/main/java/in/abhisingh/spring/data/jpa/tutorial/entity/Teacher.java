package in.abhisingh.spring.data.jpa.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teacher")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_seq")
    @SequenceGenerator(name = "teacher_seq", sequenceName = "teacher_seq", allocationSize = 1)
    private Long teacherId;
    private String firstName;
    private String lastname;

    // As Per JPA specification, you should always go for ManyToOne Relationship whenever possible.
    // Rather than having a list here, let's have a teacherId in Course.
    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    // private List<Course> courses;
}