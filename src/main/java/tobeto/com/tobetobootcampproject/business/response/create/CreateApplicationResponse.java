package tobeto.com.tobetobootcampproject.business.response.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationResponse {
    private int id;
    private int applicantId;
    private int bootcampId;
    private String applicantAbout;
    private int applicationStateId;
    private String applicantFirstName;
}
