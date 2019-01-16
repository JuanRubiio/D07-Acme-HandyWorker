package repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import domain.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application,Integer>{
	
	//Enunciado: Seleccionar las SOLICITUDES para las TAREAS del CLIENTE
	//select app from Application app where app.fixUpTask.id =(select f from FixUpTask f where f.customer.id= parametroID);
	//FALLABA, el que esta en servicios funciona.
	@Query("select app from Application app where app.fixUpTask.id =(select f from FixUpTask f where f.customer.id= ?1)")
	List<Application> findApplicationByFixUpTaskOfCustomer(int customId);
	
	//Enunciado: Seleccionar las SOLICITUDES del MANITAS
	//select app from Application app join app.handyWorker a where a.id= parametroID;
	@Query("select app from Application app join app.handyWorker a where a.id= ?1")
	List<Application> findApplicationByHandyWorker(int handyWorkerId);
	
}
