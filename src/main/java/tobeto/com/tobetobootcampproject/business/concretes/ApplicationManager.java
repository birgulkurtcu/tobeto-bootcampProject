package tobeto.com.tobetobootcampproject.business.concretes;

import tobeto.com.tobetobootcampproject.business.abstracts.ApplicationService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateApplicationRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateApplicationResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllApplicationResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetApplicationByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateApplicationResponse;
import tobeto.com.tobetobootcampproject.core.aspects.logging.Loggable;
import tobeto.com.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessResult;
import tobeto.com.tobetobootcampproject.dataaaccess.ApplicationRepository;
import tobeto.com.tobetobootcampproject.entities.Application;
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
public class ApplicationManager implements ApplicationService {

    private ApplicationRepository applicationRepository;
    private ModelMapperService mapperService;

    @Override
    @Loggable
    public DataResult<CreateApplicationResponse> createApplication(
            CreateApplicationRequest request
    ) {
        Application application = mapperService.forRequest()
                .map(request,Application.class);

        application.setCreatedDate(LocalDateTime.now());

        applicationRepository.save(application);

        CreateApplicationResponse response = mapperService.forResponse()
                .map(application, CreateApplicationResponse.class);

        return new SuccessDataResult
                <CreateApplicationResponse>
                (response,"Application created successfully.");

    }

    @Override
    public DataResult<GetApplicationByIdResponse> getApplicationById(
            int id
    ) {
        Application application = applicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("There is no application with this ID."));

        GetApplicationByIdResponse response = mapperService.forResponse()
                .map(application,GetApplicationByIdResponse.class);

        return new SuccessDataResult
                <GetApplicationByIdResponse>
                (response,"Application listed successfully.");
    }

    @Override
    public DataResult<List<GetAllApplicationResponse>> getAllApplication(

    ) {
        List <Application> applications = applicationRepository.findAll();

        List <GetAllApplicationResponse> response = applications.stream()
                .map(application -> mapperService.forResponse()
                .map(application, GetAllApplicationResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllApplicationResponse>>
                (response, "All applications listed successfully.");
    }

    @Override
    public DataResult<UpdateApplicationResponse> updateApplication(
            UpdateApplicationRequest request
    ) {
        Application application = mapperService.forRequest()
                .map(request, Application.class);

        Application updatedApplication = applicationRepository.save(application);

        UpdateApplicationResponse response = mapperService.forResponse()
                .map(updatedApplication, UpdateApplicationResponse.class);

        return new SuccessDataResult
                <UpdateApplicationResponse>
                (response, "Application updated successfully.");
    }

    @Override
    public DataResult<List<GetAllApplicationResponse>> getAllSorted(
            PageDto pageDto
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()), pageDto.getSortBy());

        Pageable pageable = PageRequest.of
                (pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<Application> applications = applicationRepository.findAll(pageable);

        List <GetAllApplicationResponse> response = applications.stream()
                .map(application -> mapperService.forResponse()
                .map(application, GetAllApplicationResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllApplicationResponse>>
                (response, "All applications sorted successfully.");
    }

    @Override
    public Result deleteApplication(
            int id
    ) {
        applicationRepository.deleteById(id);
        return new SuccessResult("Application deleted successfully.");
    }


}
