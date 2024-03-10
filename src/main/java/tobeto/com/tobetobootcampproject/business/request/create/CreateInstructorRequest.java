package tobeto.com.tobetobootcampproject.business.request.create;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInstructorRequest {
    @NotEmpty(message = "First name must not be empty!")
    @Size(min = 2, max = 50, message = "First name must be at least 2 characters!")
    private String firstName;

    @NotEmpty(message = "Last name must not be empty!")
    @Size(min = 2, max = 50, message = "Last name must be at least 2 characters!")
    private String lastName;

    @NotEmpty(message = "Email must not be empty!")
    @Email(message = "Invalid email address!")
    private String email;

    @NotEmpty(message = "Password must not be empty!")
    @Size(min = 5, max = 30, message = "Password must be between 5 and 25 characters!")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$",
            message = "Password must contain at least one lowercase letter, one uppercase letter and one digit character.")
    private String password;

    @NotEmpty(message = "User name must not be empty!")
    @Size(min = 2, max = 50, message = "User name must be at least 2 characters!")
    private String userName;

    @Size(min = 2, max = 50, message = "National identity must be exactly 11 characters.")
    private String nationalIdentity;

    @NotNull(message = "Date of birth must not be null.")
    @PastOrPresent(message = "Date of birth must be in the past or present.")
    private Date dateOfBirth;

    @NotEmpty(message = "Company name must not be empty!")
    private String companyName;
}
