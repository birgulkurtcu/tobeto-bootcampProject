package tobeto.com.tobetobootcampproject.business.response.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeResponse {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String position;
    private String nationalIdentity;
    private Date dateOfBirth;
}
