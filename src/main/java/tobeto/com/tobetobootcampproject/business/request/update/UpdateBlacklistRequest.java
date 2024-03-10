package tobeto.com.tobetobootcampproject.business.request.update;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlacklistRequest {
    @NotNull
    private int id;

    @NotEmpty(message = "Reason must not be empty!")
    private String reason;

    private LocalDateTime date;

    @NotNull(message = "Applicant ID must not be null!")
    private int applicantId;
}
