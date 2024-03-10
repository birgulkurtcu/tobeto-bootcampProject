package tobeto.com.tobetobootcampproject.business.request.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

 @Data
 @AllArgsConstructor
 @NoArgsConstructor
public class UpdateUserRequest {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String userName;
    private String nationalIdentity;
    private Date dateOfBirth;
}
