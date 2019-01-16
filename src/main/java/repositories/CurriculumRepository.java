package repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import domain.Curriculum;

public interface CurriculumRepository extends JpaRepository<Curriculum, Integer> {
	@Query("select c from Curriculum c where c.ticker = ?1")
	Curriculum findByTicket(String ticker);
}
