package tobeto.com.tobetobootcampproject.business.concretes;

import tobeto.com.tobetobootcampproject.business.abstracts.BlacklistService;
import tobeto.com.tobetobootcampproject.business.request.create.CreateBlacklistRequest;
import tobeto.com.tobetobootcampproject.business.request.update.UpdateBlacklistRequest;
import tobeto.com.tobetobootcampproject.business.response.create.CreateBlacklistResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllBlackListResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetBlackListByIdResponse;
import tobeto.com.tobetobootcampproject.business.response.update.UpdateBlacklistResponse;
import tobeto.com.tobetobootcampproject.core.aspects.logging.Loggable;
import tobeto.com.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.Result;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessResult;
import tobeto.com.tobetobootcampproject.dataaaccess.BlacklistRepository;
import tobeto.com.tobetobootcampproject.entities.Blacklist;
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
public class BlacklistManager implements BlacklistService {

    private ModelMapperService mapperService;
    private BlacklistRepository blacklistRepository;

    @Override
    @Loggable
    public DataResult<CreateBlacklistResponse> createBlacklist(
            CreateBlacklistRequest request
    ) {
        Blacklist blacklist = mapperService.forRequest()
                .map(request,Blacklist.class);

        blacklist.setCreatedDate(LocalDateTime.now());

        blacklistRepository.save(blacklist);

        CreateBlacklistResponse response = mapperService.forResponse()
                .map(blacklist,CreateBlacklistResponse.class);

        return new SuccessDataResult
                <CreateBlacklistResponse>
                (response,"Blacklist created successfully.");

    }
    @Override
    public DataResult<List<GetAllBlackListResponse>> getAllBlacklist(

    ) {
        List <Blacklist> blacklists = blacklistRepository.findAll();

        List <GetAllBlackListResponse> response = blacklists.stream()
                .map(blacklist -> mapperService.forResponse()
                .map(blacklist, GetAllBlackListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllBlackListResponse>>
                (response, "All blacklists listed successfully.");

    }
    @Override
    public DataResult<GetBlackListByIdResponse> getBlacklistById(
            int id
    ) {
        Blacklist blacklist = blacklistRepository.findById(id);

        GetBlackListByIdResponse response = mapperService.forResponse()
                .map(blacklist, GetBlackListByIdResponse.class);

        return new SuccessDataResult
                <GetBlackListByIdResponse>
                (response, "Blacklist listed successfully.");
    }

    @Override
    public DataResult<UpdateBlacklistResponse> updateBlacklist(
            UpdateBlacklistRequest request
    ) {
        Blacklist blacklist = mapperService.forRequest()
                .map(request, Blacklist.class);

        blacklist.setUpdatedDate(LocalDateTime.now());

        blacklistRepository.save(blacklist);

        UpdateBlacklistResponse response = mapperService.forResponse()
                .map(blacklist, UpdateBlacklistResponse.class);

        return new SuccessDataResult
                <UpdateBlacklistResponse>
                (response, "Blacklist updated successfully.");
    }

    @Override
    public DataResult<List<GetAllBlackListResponse>> getAllSorted(
            PageDto pageDto
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()),
                pageDto.getSortBy());

        Pageable pageable = PageRequest.of
                (pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<Blacklist> blacklists = blacklistRepository.findAll(pageable);

        List <GetAllBlackListResponse> response = blacklists.stream()
                .map(blacklist -> mapperService.forResponse()
                .map(blacklist, GetAllBlackListResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllBlackListResponse>>
                (response, "All blacklists sorted successfully");
    }

    @Override
    public Result deleteBlacklist(
            int id
    ) {
        blacklistRepository.deleteById(id);

        return new SuccessResult("Blacklist deleted successfully!");
    }
}
