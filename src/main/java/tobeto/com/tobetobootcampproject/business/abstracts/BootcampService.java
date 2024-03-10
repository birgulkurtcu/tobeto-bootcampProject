package tobeto.com.tobetobootcampproject.business.abstracts;

import tobeto.com.tobetobootcampproject.business.request.create.CreateBootcampRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateBootcampRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateBootcampResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllBootcampResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetBootcampByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateBootcampResponse;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessDataResult;

import java.util.List;

public interface BootcampService {
    DataResult<CreateBootcampResponse> createBootcamp(
            CreateBootcampRequest request
    );

    SuccessDataResult<List<GetAllBootcampResponse>> getAllBootcamp(

    );

    DataResult<GetBootcampByIdResponse> getBootcampById(
            int id
    );
    DataResult<UpdateBootcampResponse> updateBootcamp(
            UpdateBootcampRequest request
    );

    DataResult<List<GetAllBootcampResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteBootcamp(
            int id
    );

}
