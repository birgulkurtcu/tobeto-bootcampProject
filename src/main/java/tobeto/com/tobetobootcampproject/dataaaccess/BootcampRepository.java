package tobeto.com.tobetobootcampproject.dataaaccess;

import tobeto.com.tobetobootcampproject.entities.Bootcamp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BootcampRepository extends JpaRepository<Bootcamp,Integer> {
    Bootcamp deleteById(int id);
    Bootcamp findByname(String name);
}
