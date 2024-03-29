package tobeto.com.tobetobootcampproject.business.response.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampResponse {
    private int id;
    private String name;
    private int instructorId;
    private LocalDateTime startDate;
    private  LocalDateTime endDate;
    private int bootcampStateId;
    private String instructorCompanyName;
    private String instructorFirstName;
}
