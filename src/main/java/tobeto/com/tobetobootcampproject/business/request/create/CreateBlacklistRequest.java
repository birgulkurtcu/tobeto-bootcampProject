package tobeto.com.tobetobootcampproject.business.request.create;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBlacklistRequest {
    @NotEmpty(message = "Reason must not be empty!")
    private String reason;

    private LocalDateTime date;

    @NotNull(message = "Applicant ID must not be null!")
    private int applicantId;
}
