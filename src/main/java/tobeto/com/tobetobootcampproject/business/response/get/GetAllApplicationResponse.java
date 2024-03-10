package tobeto.com.tobetobootcampproject.business.response.get;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllApplicationResponse {
    private int id;
    private String applicantAbout;
    private int applicantId;
    private int bootcampId;
    private int applicationStateId;
}
