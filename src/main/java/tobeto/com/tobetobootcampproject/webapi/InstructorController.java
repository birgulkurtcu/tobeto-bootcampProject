package tobeto.com.tobetobootcampproject.webapi;

import tobeto.com.tobetobootcampproject.business.abstracts.InstructorService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateInstructorRequest;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/instructors")
@AllArgsConstructor
public class InstructorController extends BaseController {

    private InstructorService instructorService;

    @PostMapping
    public ResponseEntity<?> createInstructor(
            @RequestBody @Valid CreateInstructorRequest request
    ){
        return handleDataResult(instructorService.createInstructor(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllInstructors(

    ){
        return handleDataResult(instructorService.getAllInstructor());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstructorById(
            @PathVariable int id
    ){
        return handleDataResult(instructorService.getInstructor(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInstructor(
            @RequestBody @Valid UpdateInstructorRequest request,
            @PathVariable int id
    ){
        return handleDataResult(instructorService.updateInstructorById(request, id));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllApplicant(
            @RequestBody PageDto pageDto
    ){
        return handleDataResult(instructorService.getAllSorted(pageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteInstructor(
            @PathVariable int id
    ){
        return handleResult(instructorService.deleteInstructorById(id));
    }
}
