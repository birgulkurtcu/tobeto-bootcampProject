package tobeto.com.tobetobootcampproject.business.request.create;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBootcampStateRequest {

    @NotEmpty(message = "Name must not be empty!")
    private String name;
}
