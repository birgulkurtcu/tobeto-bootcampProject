package tobeto.com.tobetobootcampproject.webapi;

import tobeto.com.tobetobootcampproject.business.abstracts.ApplicationService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateApplicationRequest;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/applications")
@AllArgsConstructor
public class ApplicationController extends BaseController {

    private ApplicationService applicationService;

    @PostMapping
    public ResponseEntity<?> createApplication(
            @RequestBody @Valid CreateApplicationRequest request
    ){
        return handleDataResult(applicationService.createApplication(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getApplicationById(
            @PathVariable int id
    ){
        return handleDataResult(applicationService.getApplicationById(id));
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAllApplication(

    ){
        return handleDataResult(applicationService.getAllApplication());
    }

    @PutMapping
    public ResponseEntity<?> updateApplication(
            @RequestBody @Valid UpdateApplicationRequest request
    ){
        return handleDataResult(applicationService.updateApplication(request));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllApplicant(
            @RequestBody PageDto pageDto)
    {
        return handleDataResult(applicationService.getAllSorted(pageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteApplication(
            @PathVariable int id
    ){
        return handleResult(applicationService.deleteApplication(id));
    }
}
