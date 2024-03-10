package tobeto.com.tobetobootcampproject.webapi;

import tobeto.com.tobetobootcampproject.business.abstracts.BlacklistService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateBlacklistRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateBlacklistRequest;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/blacklists")
@AllArgsConstructor
public class BlacklistController extends BaseController{

    private BlacklistService blacklistService;

    @PostMapping
    public ResponseEntity<?> createBlacklist(
            @RequestBody @Valid CreateBlacklistRequest request
    ) {
        return handleDataResult(blacklistService.createBlacklist(request));
    }

    @GetMapping
    public ResponseEntity<?> getAllBlacklists(

    ){
        return handleDataResult(blacklistService.getAllBlacklist());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBlacklistById(
            @PathVariable int id
    ){
        return handleDataResult(blacklistService.getBlacklistById(id));
    }

    @PutMapping
    public ResponseEntity<?> updateBlacklist(
            @RequestBody @Valid UpdateBlacklistRequest request
    ){
        return handleDataResult(blacklistService.updateBlacklist(request));
    }

    @GetMapping("/sort")
    public ResponseEntity<?> getAllBlacklists(
            @RequestBody PageDto pageDto
    ){
        return handleDataResult(blacklistService.getAllSorted(pageDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBlacklist(
            @PathVariable int id
    ){
        return handleResult(blacklistService.deleteBlacklist(id));
    }



}
