package tobeto.com.tobetobootcampproject.core.exceptions.problemdetails;

import org.springframework.http.HttpStatus;

public class InternalServerErrorProblemDetails extends ProblemDetails{
    public InternalServerErrorProblemDetails() {
        setTitle("Internal Server Error");
        setType("https://lms.tobeto.com/exceptions/internal");
        setStatus(HttpStatus.INTERNAL_SERVER_ERROR.toString());
    }
}
