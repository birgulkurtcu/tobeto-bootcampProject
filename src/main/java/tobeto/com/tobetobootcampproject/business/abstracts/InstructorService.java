package tobeto.com.tobetobootcampproject.business.abstracts;

import tobeto.com.tobetobootcampproject.business.request.create.CreateInstructorRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateInstructorRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateInstructorResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllInstructorResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetInstructorByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateInstructorResponse;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface InstructorService {
     DataResult<CreateInstructorResponse> createInstructor(
            CreateInstructorRequest request
    );

    DataResult<List<GetAllInstructorResponse>> getAllInstructor(

    );

    DataResult<GetInstructorByIdResponse> getInstructor(
            int id
    );

    DataResult<UpdateInstructorResponse> updateInstructorById(
            UpdateInstructorRequest request,
            int id
    );

    DataResult<List<GetAllInstructorResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteInstructorById(
            int id
    );
}
