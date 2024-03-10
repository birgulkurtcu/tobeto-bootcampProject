package tobeto.com.tobetobootcampproject.business.abstracts;


import tobeto.com.tobetobootcampproject.business.request.create.CreateApplicationRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateApplicationRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateApplicationResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllApplicationResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetApplicationByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateApplicationResponse;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationService {
    DataResult<CreateApplicationResponse> createApplication(
            CreateApplicationRequest request
    );

    DataResult<GetApplicationByIdResponse> getApplicationById(
            int id
    );

    DataResult<List<GetAllApplicationResponse>> getAllApplication(

    );

    DataResult<UpdateApplicationResponse> updateApplication(
            UpdateApplicationRequest request
    );

    DataResult<List<GetAllApplicationResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteApplication(
            int id
    );


}
