package tobeto.com.tobetobootcampproject.dataaaccess;

import tobeto.com.tobetobootcampproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findById(int id);

    User findByEmail(String email);

    User getByEmail(String email);

    User findByuserName(String username);
    User findBynationalIdentity(String nationalIdentity);



}
