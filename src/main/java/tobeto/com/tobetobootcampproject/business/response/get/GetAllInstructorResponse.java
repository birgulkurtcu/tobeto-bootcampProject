package tobeto.com.tobetobootcampproject.business.response.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllInstructorResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String companyName;
    private LocalDateTime dateOfBirth;
}
