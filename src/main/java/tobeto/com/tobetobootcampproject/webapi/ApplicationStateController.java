package tobeto.com.tobetobootcampproject.webapi;

import tobeto.com.tobetobootcampproject.business.abstracts.ApplicationStateService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateApplicationStateRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateApplicationStateRequest;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applicationstates")
@AllArgsConstructor
public class ApplicationStateController extends BaseController{

    private ApplicationStateService applicationStateService;

    @PostMapping
    ResponseEntity<?> createApplicationState(
            @RequestBody @Valid CreateApplicationStateRequest request
    ){
        return handleDataResult(applicationStateService.createApplicationState(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllApplicationStates(

    ){
        return handleDataResult(applicationStateService.getAllStates());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicationStateById(
            @PathVariable int id
    ){
        return handleDataResult(applicationStateService.getApplicationStateById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateApplicationState(
            @RequestBody @Valid UpdateApplicationStateRequest request
    ){
        return handleDataResult(applicationStateService.updateApplicationState(request));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllApplicant
            (@RequestBody PageDto pageDto)
    {
        return handleDataResult(applicationStateService.getAllSorted(pageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplicantState(
            @PathVariable int id)
    {
        return handleResult(applicationStateService.deleteApplicationState(id));
    }


}
