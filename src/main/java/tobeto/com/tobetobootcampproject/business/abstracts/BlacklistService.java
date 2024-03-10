package tobeto.com.tobetobootcampproject.business.abstracts;

import tobeto.com.tobetobootcampproject.business.request.create.CreateBlacklistRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateBlacklistRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateBlacklistResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllBlackListResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetBlackListByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateBlacklistResponse;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;

import java.util.List;

public interface BlacklistService {
    DataResult<CreateBlacklistResponse> createBlacklist(
            CreateBlacklistRequest request
    );

    DataResult<List<GetAllBlackListResponse>> getAllBlacklist(

    );

    DataResult<GetBlackListByIdResponse> getBlacklistById(
            int id
    );

    DataResult<UpdateBlacklistResponse> updateBlacklist(
            UpdateBlacklistRequest request
    );

    DataResult<List<GetAllBlackListResponse>> getAllSorted(
            PageDto pageDto
    );

    Result deleteBlacklist(
            int id
    );
}
