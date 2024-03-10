package tobeto.com.tobetobootcampproject.business.abstracts;

import tobeto.com.tobetobootcampproject.business.request.create.CreateApplicantRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateApplicantRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateApplicantResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllApplicantResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetApplicantByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateApplicantResponse;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;


public interface ApplicantService {
    DataResult<CreateApplicantResponse> createApplicant(
            CreateApplicantRequest request);

    DataResult<GetApplicantByIdResponse> getApplicantById(
            int id
    );

    DataResult<List<GetAllApplicantResponse>> getAllApplicant(

    );

    DataResult<List<GetAllApplicantResponse>> getAllSorted(
            PageDto pageDto
    );

    DataResult<UpdateApplicantResponse> updateApplicantById(
            UpdateApplicantRequest request,
            int id
    );

    Result deleteApplicantById(
            int id
    );
}
