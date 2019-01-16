
package services;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import repositories.PhaseRepository;
import domain.Application;
import domain.Phase;

@Service
@Transactional
public class PhaseService {

	@Autowired
	private PhaseRepository	phaseRepository;

	public Phase create(final Application application) {
		final Phase res = new Phase();
		Assert.notNull(application);
		Assert.isTrue(application.getStatus().equals("ACCEPTED"));
		//La intenci�n es parsear el TimeStamp en date
		final Timestamp stamp = new Timestamp(System.currentTimeMillis());
		final Date startMoment = new Date(stamp.getTime());
		res.setStartMoment(startMoment);

		return res;
	}

	public Phase findOne(final Integer phaseId) {
		Phase res;
		Assert.notNull(phaseId);
		res = this.phaseRepository.findOne(phaseId);
		Assert.notNull(res);
		return res;
	}
	
	public Collection<Phase> findAll(){
		Collection<Phase> res;
		res=this.phaseRepository.findAll();
		Assert.notNull(res);
		return res;
	}

	public Phase save(final Phase phase) {
		Phase res;
		Assert.notNull(phase);
		res = this.phaseRepository.save(phase);
		Assert.notNull(res);
		return res;
	}

	public void delete(final Phase phase) {
		Assert.notNull(phase);
		this.phaseRepository.save(phase);
	}
}
