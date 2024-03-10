package tobeto.com.tobetobootcampproject.business.concretes;

import tobeto.com.tobetobootcampproject.business.abstracts.BootcampStateService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateBootcampStateRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateBootcampStateRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateBootcampStateResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllBootcampStateResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetBootcampStateByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateBootcampStateResponse;
import tobeto.com.tobetobootcampproject.core.aspects.logging.Loggable;
import tobeto.com.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessResult;
import tobeto.com.tobetobootcampproject.dataaaccess.BootcampStateRepository;
import tobeto.com.tobetobootcampproject.entities.BootcampState;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BootcampStateManager implements BootcampStateService {
    private BootcampStateRepository bootcampStateRepository;
    private ModelMapperService mapperService;
    @Override
    @Loggable
    public DataResult<CreateBootcampStateResponse> createBootcampState(
            CreateBootcampStateRequest request
    ) {
        BootcampState bootcampState = mapperService.forRequest()
                .map(request,BootcampState.class);

        bootcampState.setCreatedDate(LocalDateTime.now());

        bootcampStateRepository.save(bootcampState);

        CreateBootcampStateResponse response = mapperService.forResponse()
                .map(bootcampState, CreateBootcampStateResponse.class);

        return new SuccessDataResult
                <CreateBootcampStateResponse>
                (response,"Bootcamp state created.");
    }

    @Override
    public DataResult<List<GetAllBootcampStateResponse>> getAllBootcampStates(

    ) {
        List <BootcampState> bootcampStates = bootcampStateRepository.findAll();

        List <GetAllBootcampStateResponse> response = bootcampStates.stream()
                .map(bootcampState -> mapperService.forResponse()
                .map(bootcampState, GetAllBootcampStateResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllBootcampStateResponse>>
                (response, "All Bootcamp States Listed");
    }

    @Override
    public DataResult<GetBootcampStateByIdResponse> getBootcampState(
            int id
    ) {
        BootcampState bootcampState = bootcampStateRepository.findById(id).orElseThrow();

        GetBootcampStateByIdResponse response = mapperService.forResponse()
                .map(bootcampState, GetBootcampStateByIdResponse.class);

        return new SuccessDataResult
                <GetBootcampStateByIdResponse>
                (response, "Bootcamp State Listed");

    }

    @Override
    public DataResult<UpdateBootcampStateResponse> updateBootcampState(
            UpdateBootcampStateRequest request
    ) {
        BootcampState bootcampState = mapperService.forRequest().map(request, BootcampState.class);

        BootcampState updatedBootcampState = bootcampStateRepository.save(bootcampState);

        UpdateBootcampStateResponse response = mapperService.forResponse()
                .map(updatedBootcampState, UpdateBootcampStateResponse.class);

        return new SuccessDataResult
                <UpdateBootcampStateResponse>
                (response, "Bootcamp State Updated");
    }

    @Override
    public DataResult<List<GetAllBootcampStateResponse>> getAllSorted(
            PageDto pageDto
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()), pageDto.getSortBy());

        Pageable pageable = PageRequest.of
                (pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<BootcampState> bootcampStates = bootcampStateRepository
                .findAll(pageable);

        List <GetAllBootcampStateResponse> response = bootcampStates.stream()
                .map(bootcampState -> mapperService.forResponse()
                .map(bootcampState, GetAllBootcampStateResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllBootcampStateResponse>>
                (response, "All Bootcamp Stetes Sorted");
    }

    @Override
    public Result deleteBootcampState(
            int id
    ) {
        bootcampStateRepository.deleteById(id);
        return new SuccessResult("Bootcamp State Deleted");
    }
}
