package tobeto.com.tobetobootcampproject.business.concretes;

import tobeto.com.tobetobootcampproject.business.abstracts.ApplicationStateService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateApplicationStateRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateApplicationStateRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateApplicationStateResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllApplicationStateResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetApplicationStateByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateApplicationStateResponse;
import tobeto.com.tobetobootcampproject.core.aspects.logging.Loggable;
import tobeto.com.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessResult;
import tobeto.com.tobetobootcampproject.dataaaccess.ApplicationStateRepository;
import tobeto.com.tobetobootcampproject.entities.ApplicationState;
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
public class ApplicationStateManager implements ApplicationStateService {

    private ApplicationStateRepository applicationStateRepository;
    private ModelMapperService mapperService;

    @Override
    @Loggable
    public DataResult<CreateApplicationStateResponse> createApplicationState(
            CreateApplicationStateRequest request
    ) {
        ApplicationState applicationState = mapperService.forRequest()
                .map(request,ApplicationState.class);

        applicationState.setCreatedDate(LocalDateTime.now());

        applicationStateRepository.save(applicationState);

        CreateApplicationStateResponse response = mapperService.forResponse()
                .map(applicationState,CreateApplicationStateResponse.class);

        return new SuccessDataResult
                <CreateApplicationStateResponse>
                (response,"Application State created successfully.");

    }

    @Override
    public DataResult<List<GetAllApplicationStateResponse>> getAllStates(

    ) {
        List <ApplicationState> applicationStates = applicationStateRepository.findAll();

        List <GetAllApplicationStateResponse> response = applicationStates.stream()
                .map(applicationState -> mapperService.forResponse()
                .map(applicationState, GetAllApplicationStateResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllApplicationStateResponse>>
                (response, "All application states listed successfully.");
    }

    @Override
    public DataResult<GetApplicationStateByIdResponse> getApplicationStateById(
            int id
    ) {
        ApplicationState applicationState = applicationStateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no Application State with this ID."));

        GetApplicationStateByIdResponse response = mapperService.forResponse()
                .map(applicationState, GetApplicationStateByIdResponse.class);

        return new SuccessDataResult
                <GetApplicationStateByIdResponse>
                (response, "Application states listed successfully.");

    }

    @Override
    public DataResult<UpdateApplicationStateResponse> updateApplicationState(
            UpdateApplicationStateRequest request
    ) {
        ApplicationState applicationState = mapperService.forRequest()
                .map(request, ApplicationState.class);

        ApplicationState updatedApplicationState = applicationStateRepository.save(applicationState);

        UpdateApplicationStateResponse response = mapperService.forResponse()
                .map(updatedApplicationState, UpdateApplicationStateResponse.class);

        return new SuccessDataResult
                <UpdateApplicationStateResponse>
                (response, "Application state updated successfully");
    }

    @Override
    public DataResult<List<GetAllApplicationStateResponse>> getAllSorted(
            PageDto pageDto
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()), pageDto.getSortBy());

        Pageable pageable = PageRequest.of
                (pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<ApplicationState> applicationStates = applicationStateRepository.findAll(pageable);

        List <GetAllApplicationStateResponse> response = applicationStates.stream()
                .map(applicationState -> mapperService.forResponse()
                .map(applicationState, GetAllApplicationStateResponse.class)).collect(Collectors.toList());

        return new
                SuccessDataResult
                        <List<GetAllApplicationStateResponse>>
                (response, "All application states sorted successfully.");
    }

    // test et!
    @Override
    public Result deleteApplicationState(
            int id
    ) {
        applicationStateRepository.deleteById(id);

        return new SuccessResult("Application states deleted successfully.");
    }


}
