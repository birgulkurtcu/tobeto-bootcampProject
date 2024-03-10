package tobeto.com.tobetobootcampproject.business.abstracts;

import tobeto.com.tobetobootcampproject.business.response.get.GetAllUserResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetUserByEmailResponse;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;

import java.util.List;

public interface UserService {
    DataResult<List<GetAllUserResponse>> getAll(

    );

    DataResult<GetUserByEmailResponse> getUserByEmail(
            String email
    );

    DataResult<List<GetAllUserResponse>> getAllSorted(
            PageDto pageDto
    );
}
