package tobeto.com.tobetobootcampproject.webapi;

import tobeto.com.tobetobootcampproject.business.abstracts.BootcampService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateBootcampRequest;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/bootcamps")
@AllArgsConstructor
public class BootcampController extends BaseController {

    private BootcampService bootcampService;

    @PostMapping
    public ResponseEntity<?> createBootcamp(
            @RequestBody @Valid CreateBootcampRequest request
    ) {
        return handleDataResult(bootcampService.createBootcamp(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllBootcamp(

    ){
        return handleDataResult(bootcampService.getAllBootcamp());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBootcampById(
            @PathVariable int id
    ){
        return handleDataResult(bootcampService.getBootcampById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateBootcamp(
            @RequestBody @Valid UpdateBootcampRequest request
    ){
        return handleDataResult(bootcampService.updateBootcamp(request));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllSorted(
            @RequestBody PageDto pageDto
    ){
        return handleDataResult(bootcampService.getAllSorted(pageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBootcamp(
            @PathVariable int id
    ){
        return handleResult(bootcampService.deleteBootcamp(id));
    }
}
