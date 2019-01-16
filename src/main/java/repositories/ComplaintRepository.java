
package repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Complaint;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer> {

	@Query("select c.id from Complaint c")
	List<Integer> idTodasLasQuejas();

	@Query("select r.complaint.id from Report r join r.complaint c")
	List<Integer> idQuejasConReferee();

	@Query("select f.complaints from FixUpTask f where f.customer.id=?1")
	Collection<Complaint> quejasPorCustomer(Integer customerId);

}
