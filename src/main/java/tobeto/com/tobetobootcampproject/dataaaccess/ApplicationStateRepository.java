package tobeto.com.tobetobootcampproject.dataaaccess;

import tobeto.com.tobetobootcampproject.entities.ApplicationState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationStateRepository extends JpaRepository<ApplicationState,Integer> {
}
