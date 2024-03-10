package tobeto.com.tobetobootcampproject.business.abstracts;

import tobeto.com.tobetobootcampproject.business.request.create.CreateBootcampStateRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateBootcampStateRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateBootcampStateResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllBootcampStateResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetBootcampStateByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateBootcampStateResponse;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface BootcampStateService {
    DataResult<CreateBootcampStateResponse> createBootcampState(
            CreateBootcampStateRequest request
    );
    DataResult<List<GetAllBootcampStateResponse>> getAllBootcampStates(

    );

    DataResult<GetBootcampStateByIdResponse> getBootcampState(
            int id
    );

    DataResult<UpdateBootcampStateResponse> updateBootcampState(
            UpdateBootcampStateRequest request
    );

    DataResult<List<GetAllBootcampStateResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteBootcampState(
            int id
    );
}
