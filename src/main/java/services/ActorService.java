
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.ActorRepository;
import security.LoginService;
import domain.Actor;
import domain.Administrator;

@Service
@Transactional
public class ActorService {

	@Autowired
	private ActorRepository	actorRepository;


	public Collection<Actor> findAll() {
		Collection<Actor> result;

		result = this.actorRepository.findAll();

		Assert.notNull(result);

		return result;

	}

	public Actor findOne(final Integer actorId) {
		Actor result;
		Assert.notNull(actorId);

		result = this.actorRepository.findOne(actorId);

		Assert.notNull(result);
		return result;

	}

	public Actor save(final Actor actor) {
		Actor result;
		Assert.notNull(actor);

		result = this.actorRepository.save(actor);
		Assert.notNull(result);
		return result;

	}

	public void delete(final Actor actor) {
		Assert.notNull(actor);
		this.actorRepository.delete(actor);

	}

	public Actor getPrincipal() {

		final Actor result = this.actorRepository.getPrincipal(LoginService.getPrincipal().getId());
		Assert.notNull(result);

		return result;
	}

	public void banActor(final Integer actorId, final Boolean option) {
		final Administrator administrator = (Administrator) this.getPrincipal();
		final Actor actor = this.findOne(actorId);
		Assert.isTrue(administrator.getId() != actor.getId());
		actor.getUserAccount().setEnabled(option);
		this.save(actor);
	}

	public Boolean isSuspicious(final Integer actorId) {
		Boolean res = false;

		final Actor act = this.findOne(actorId);
		Assert.notNull(act);
		if (act.getSuspicious())
			res = true;

		return res;
	}

	public Collection<Actor> getSuspiciousActors() {
		return this.actorRepository.getSuspiciousActors();
	}

	public Collection<Actor> getNotSuspiciousActors() {
		return this.actorRepository.getNotSuspiciousActors();
	}

}
