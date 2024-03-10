package tobeto.com.tobetobootcampproject.business.abstracts;

import tobeto.com.tobetobootcampproject.business.request.create.CreateApplicationStateRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateApplicationStateRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateApplicationStateResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllApplicationStateResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetApplicationStateByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateApplicationStateResponse;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface ApplicationStateService {
    DataResult<CreateApplicationStateResponse> createApplicationState(
            CreateApplicationStateRequest request
    );
    DataResult<List<GetAllApplicationStateResponse>> getAllStates(

    );
    DataResult<GetApplicationStateByIdResponse> getApplicationStateById(
            int id
    );
    DataResult<UpdateApplicationStateResponse> updateApplicationState(
            UpdateApplicationStateRequest request
    );

    DataResult<List<GetAllApplicationStateResponse>> getAllSorted(
            PageDto pageDto
    );
    Result deleteApplicationState(
            int id
    );


}
