package tobeto.com.tobetobootcampproject.business.rules;

import tobeto.com.tobetobootcampproject.core.exceptions.types.BusinessException;
import tobeto.com.tobetobootcampproject.dataaaccess.UserRepository;
import tobeto.com.tobetobootcampproject.entities.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserBusinessRules {

    private UserRepository userRepository;

    public void checkIfEmailExist(
            String email
    ){
        User user = userRepository.getByEmail(email.trim());
        if (user != null) {
            throw new BusinessException("This email is already used!");
        }
    }
    public void checkIfUsernameExist(
            String username
    ){
        User user = userRepository.findByuserName(username.trim());
        if (user != null) {
            throw new BusinessException("This username is already used!");
        }
    }
    public void checkIfNationalIdentityExist(
            String nationalIdentity
    ){
        User user = userRepository.findBynationalIdentity(nationalIdentity.trim());
        if (user != null) {
            throw new BusinessException("This national identity is already used!");
        }
    }
}
