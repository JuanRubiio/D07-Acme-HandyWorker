
package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.ApplicationRepository;
import security.Authority;
import domain.Actor;
import domain.Application;
import domain.CreditCard;
import domain.FixUpTask;

@Service
@Transactional
public class ApplicationService {

	@Autowired
	private ApplicationRepository	applicationRepository;
	@Autowired
	private ActorService	actorService;
	@Autowired
	private FixUpTaskService	fixUpTaskService;
	

	public Application create(final FixUpTask fixUpTaskId) {

		final Application res = new Application();
		Assert.notNull(fixUpTaskId);
		final Actor actor = this.actorService.getPrincipal();
		final Collection<Authority> autorities = actor.getUserAccount().getAuthorities();
		final ArrayList<String> listAuth = new ArrayList<String>();

		if (!autorities.isEmpty())
			for (final Authority au : autorities)
				listAuth.add(au.getAuthority());

		Assert.isTrue(listAuth.contains("HANDYWORKER"));
		res.setMoment(new Date());
		
		return res;
	}

	public Collection<Application> findAll() {
		Collection<Application> res;
		res = this.applicationRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public Application findOne(final Integer applicationId) {
		Application res;
		Assert.notNull(applicationId);
		res = this.applicationRepository.findOne(applicationId);
		Assert.notNull(res);
		return res;
	}

	public Application save(final Application application) {
		Application res;
		Assert.notNull(application);
		res = this.applicationRepository.save(application);
		Assert.notNull(res);
		return res;
	}

	public Boolean checkAccepted(final Integer appId, final CreditCard creditc) {
		Boolean res = false;

		final Application ap = this.findOne(appId);
		Assert.notNull(ap);
		if (ap.getStatus().equals("ACCEPTED")) {
			ap.setCreditCard(creditc);
			this.save(ap);
			res = true;
		}
		return res;

	}
	
	public List<Application> findApplicationByFixUpTaskOfCustomer(Integer customId){
		List<FixUpTask> allFUT = new ArrayList<FixUpTask>(); 
		allFUT.addAll(this.fixUpTaskService.findAll());
		List<FixUpTask> customerFUT = new ArrayList<FixUpTask>(); 
		List<Application> res = new ArrayList<Application>();
		Integer i=0;
		for(i=0;i<allFUT.size();i++){
			if(allFUT.get(i).getCustomer().getId()==customId){
				customerFUT.add(allFUT.get(i));
			}
		}
		for(i=0;i<customerFUT.size();i++){
			res.addAll(customerFUT.get(i).getApplications());
		}
		
		System.out.println("findApplicationByFixUpTaskOfCustomer"+res);
		return res;
	}

	public List<Application> findApplicationByHandyWorker (Integer handyworkerId){
		List<Application> res = new ArrayList<Application>(); 
		List<Application> allApplication = new ArrayList<Application>(); 
		allApplication.addAll(findAll());
		Integer i=0;
		for(i=0;i<allApplication.size();i++){
			if(allApplication.get(i).getHandyWorker().getId()==handyworkerId){
				res.add(allApplication.get(i));
			}
		}
		System.out.println("findApplicationByHandyWorker"+res);
		return res;
	}
	
}
