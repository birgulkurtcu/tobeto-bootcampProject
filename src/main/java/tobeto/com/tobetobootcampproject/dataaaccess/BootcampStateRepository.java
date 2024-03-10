package tobeto.com.tobetobootcampproject.dataaaccess;

import tobeto.com.tobetobootcampproject.entities.BootcampState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampStateRepository extends JpaRepository<BootcampState,Integer> {
}
