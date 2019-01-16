
package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Administrator;
import domain.Customer;
import domain.HandyWorker;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {

	@Query("select avg(c.fixUpTasks.size),min(c.fixUpTasks.size),max(c.fixUpTasks.size),stddev(c.fixUpTasks.size) from Customer c")
	List<Object> query1();

	@Query("select avg(fut.applications.size),min(fut.applications.size),max(fut.applications.size),stddev(fut.applications.size) from FixUpTask fut")
	List<Object> query2();

	@Query("select min(f.maxPrice),avg(f.maxPrice), stddev(f.maxPrice),max(f.maxPrice)from FixUpTask f")
	List<Object> query3();

	@Query("select min(a.price),avg(a.price), stddev(a.price),max(a.price)from Application a")
	List<Object> query4();

	@Query("select sum(case when a.status='PENDING' then 1.00 else 0.00 end)/count(a)*1.0 from Application a")
	Double query5();

	@Query("select 1.0*count(a)/(select count(a) from Application a) from Application a join a.fixUpTask f where a.status = 'PENDING' and a.moment > f.maxDate")
	Double query6();

	@Query("select hw from HandyWorker hw join hw.applications a where ((a.status='ACCEPTED')and (a.size>=(select 1.1*(sum(hw.applications.size)/count(hw))from HandyWorker hw)))")
	HandyWorker query7();

	@Query("select sum(case when a.status='ACCEPTED' then 1.00 else 0.00 end)/count(a)*1.0 from Application a")
	Double query8();

	@Query("select c from Customer c join c.fixUpTasks fut where (c.fixUpTasks.size >= (select avg(cc.fixUpTasks.size) from Customer cc)*1.10) order by fut.applications.size")
	Customer query9();

	@Query("select sum(case when a.status='REJECTED' then 1.00 else 0.00 end)/count(a)*1.0 from Application a")
	Double query10();

	@Query("select min(f.complaints.size), max(f.complaints.size), avg(f.complaints.size), stddev(f.complaints.size) from FixUpTask f")
	List<Object> query11();

	@Query("select min(r.collectionNotes.size), max(r.collectionNotes.size), avg(r.collectionNotes.size), stddev(r.collectionNotes.size)from Report r")
	List<Object> query12();

	@Query("select sum(case when fut.complaints.size=1 then 1.00 else 0.00 end)/count(fut)*1.0 from FixUpTask fut")
	Double query13();

	@Query("select c from Customer c order by c.fixUpTasks.size desc")
	Customer query14();

	@Query("select a.handyWorker from Application a join a.fixUpTask fut order by fut.complaints.size desc")
	HandyWorker query15();
}
