package in.abhisingh.spring.data.jpa.tutorial.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "course_material")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_seq")
    @SequenceGenerator(name = "course_material_seq", sequenceName = "course_material_seq", allocationSize = 1)
    private Long courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "course_id", referencedColumnName = "courseId")
    private Course course;
}