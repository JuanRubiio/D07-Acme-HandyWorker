
package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Report;
import domain.Sponsorship;

@Repository
public interface ReportRepository extends JpaRepository<Report, Integer> {
	
	@Query("select r from Report r where r.complaint.id = ?1")
	Collection<Report> findByComplaintId(int complaintID);

}
