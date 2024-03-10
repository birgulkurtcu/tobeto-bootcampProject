package tobeto.com.tobetobootcampproject.dataaaccess;

import tobeto.com.tobetobootcampproject.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    Application getById(int id);

    List<Application> getAllByApplicationStateId(int id);
}
