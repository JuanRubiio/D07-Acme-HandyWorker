package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import domain.Application;
import domain.Phase;

import utilities.AbstractTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"})
@Transactional
public class PhaseServiceTest extends AbstractTest{

	@Autowired
	private PhaseService phaseService;
	@Autowired
	private ApplicationService applicationService;
	
	@Test
	public void testCreatePhase(){
		super.authenticate("handyWorker1");
		Phase phase = new Phase();
		Application app = this.applicationService.findOne(1429);
		phase = this.phaseService.create(app);
		Assert.notNull(phase);
	}
	
	@Test
	public void testSavePhase(){
		super.authenticate("handyWorker1");
		Application application = this.applicationService.findOne(1429);
		Phase phase = this.phaseService.create(application);
		phase.setDescription("Hola caracola");
		phase.setTitle("Hi");
		this.phaseService.save(phase);
		Assert.notNull(phase);
	}
	
	@Test
	public void findOneTest() {
		final Phase phase = this.phaseService.findOne(1424);
		Assert.notNull(phase);
	}
	
	@Test
	public void findAllTest(){
		final Collection<Phase> phase = this.phaseService.findAll();
		Assert.notNull(phase);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDeletePhase() {
		super.authenticate("handyWorker1");
		final Phase phase = this.phaseService.findOne(1424);

		this.phaseService.delete(phase);
		this.phaseService.findOne(1824);
		super.authenticate(null);
	}
	
}
