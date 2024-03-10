package tobeto.com.tobetobootcampproject.business.concretes;

import tobeto.com.tobetobootcampproject.business.abstracts.UserService;
import tobeto.com.tobetobootcampproject.business.response.get.GetAllUserResponse;
import tobeto.com.tobetobootcampproject.business.response.get.GetUserByEmailResponse;
import tobeto.com.tobetobootcampproject.core.utilities.modelmapper.ModelMapperService;
import tobeto.com.tobetobootcampproject.core.utilities.paging.PageDto;
import tobeto.com.tobetobootcampproject.core.utilities.results.DataResult;
import tobeto.com.tobetobootcampproject.core.utilities.results.SuccessDataResult;
import tobeto.com.tobetobootcampproject.dataaaccess.UserRepository;
import tobeto.com.tobetobootcampproject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserManager implements UserService {
    private UserRepository userRepository;
    private ModelMapperService mapperService;

    @Override
    public DataResult<List<GetAllUserResponse>> getAll(

    ) {
        List <User> users = userRepository.findAll();

        List <GetAllUserResponse> userResponses = users.stream().map(user->
                mapperService.forResponse().map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<GetAllUserResponse>>(userResponses, "All Users Listed");
    }

    @Override
    public DataResult<GetUserByEmailResponse> getUserByEmail(
            String email
    ) {
        User user = userRepository.findByEmail(email);

        GetUserByEmailResponse response = mapperService.forResponse()
                .map(user, GetUserByEmailResponse.class);

        return new SuccessDataResult
                <GetUserByEmailResponse>
                (response, "User Listed By Email");
    }

    @Override
    public DataResult<List<GetAllUserResponse>> getAllSorted(
            PageDto pageDto
    ) {
        Sort sort = Sort.by(Sort.Direction.fromString
                (pageDto.getSortDirection()), pageDto.getSortBy());

        Pageable pageable = PageRequest.of
                (pageDto.getPageNumber(), pageDto.getPageSize(), sort);

        Page<User> users = userRepository.findAll(pageable);

        List <GetAllUserResponse> response = users.stream()
                .map(user -> mapperService.forResponse()
                .map(user, GetAllUserResponse.class)).collect(Collectors.toList());

        return new SuccessDataResult
                <List<GetAllUserResponse>>
                (response, "All Users Sorted");
    }
}
