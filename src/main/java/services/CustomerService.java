package services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.CustomerRepository;
import security.Authority;
import security.LoginService;
import security.UserAccount;
import domain.Actor;
import domain.Application;
import domain.Curriculum;
import domain.Customer;
import domain.HandyWorker;

@Service
@Transactional
public class CustomerService {

	//Managed repo
	@Autowired
	private CustomerRepository	customerRepository;

	@Autowired
	private ActorService		actorService;

	@Autowired
	private MessageBoxService	messageboxService;
	
	public HandyWorker create() {

		HandyWorker res;
		res = new HandyWorker();
		final UserAccount userAccount = new UserAccount();
		final Actor actor = this.actorService.getPrincipal();
		final Collection<Authority> authorities2 = actor.getUserAccount().getAuthorities();
		final List<Authority> authorities = new ArrayList<Authority>();
		final ArrayList<String> listAuth = new ArrayList<String>();
		final Authority authority = new Authority();
		authority.setAuthority(Authority.CUSTOMER);
		authorities.add(authority);
		userAccount.setAuthorities(authorities);
		res.setUserAccount(userAccount);
		
		
		if(!authorities2.isEmpty())
			for(final Authority au: authorities2)
				listAuth.add(au.getAuthority());
		Assert.isTrue(listAuth.contains("ADMIN"));
		Assert.notNull(res);
						
		final List<Application> applications = new ArrayList<Application>();
		res.setApplications(applications);
		
		final Curriculum curriculum = new Curriculum();
		res.setCurriculum(curriculum);
		
		this.messageboxService.addDefaultMessageBoxs(res);//Revisar el messageBox
		
		return res;
	}

	public Customer findOne(final Integer customerId) {
		final Customer res;
		Assert.notNull(customerId);
		res = this.customerRepository.findOne(customerId);
		Assert.notNull(res);

		return res;
	}

	public Collection<Customer> findAll() {
		Collection<Customer> res;
		res = this.customerRepository.findAll();
		Assert.notNull(res);

		return res;
	}

	public Customer save(final Customer customer) {
		Customer result;

		Assert.notNull(customer);

		result = this.customerRepository.save(customer);

		Assert.notNull(result);

		return result;

	}

	public void delete(final Customer customer) {
		Assert.notNull(customer);
		this.customerRepository.delete(customer);
	}

	//Metodos complejos

	public Customer findByPrincipal() {
		Customer result;
		result = this.customerRepository.findByUserAccountId(LoginService.getPrincipal().getId());
		Assert.notNull(result);
		return result;
	}
}