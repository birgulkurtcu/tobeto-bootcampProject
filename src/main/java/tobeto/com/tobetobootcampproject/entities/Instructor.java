package tobeto.com.tobetobootcampproject.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "instructors")
public class Instructor extends User {

    @Column(name = "companyName")
    private String companyName;

    @OneToMany(mappedBy = "instructor")
    private List<Bootcamp> bootcamps;
}
