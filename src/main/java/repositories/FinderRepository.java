
package repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Finder;
import domain.FixUpTask;

@Repository
public interface FinderRepository extends JpaRepository<Finder, Integer> {

	@Query("select fut from FixUpTask fut where ((fut.ticker like ?1 or fut.description like ?1 or fut.address like ?1) or (fut.minPrice>?2) or (fut.maxPrice < ?3) or (fut.minDate > ?4) or (fut.maxDate < ?5))")
	List<FixUpTask> findFixUpTasks(String s, Double minPrice, Double maxPrice, Date minDate, Date maxDate);
}
