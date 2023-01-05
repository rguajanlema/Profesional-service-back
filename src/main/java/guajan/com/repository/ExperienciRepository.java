package guajan.com.repository;

import guajan.com.entity.Experienci;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienciRepository extends JpaRepository<Experienci, Long> {
}