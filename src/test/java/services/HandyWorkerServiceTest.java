
package services;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.HandyWorker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class HandyWorkerServiceTest extends AbstractTest {

	@Autowired
	private HandyWorkerService	handyWorkerService;

	@Test 
	public void createTest(){
		HandyWorker handyWorker = new HandyWorker();
		handyWorker.setName("Kevin");
		handyWorker.setSurname("Durant");
		handyWorker.setEmail("durantula@gmail.com");
		handyWorker.setPhone("www.urlfoto.com/miphoto.php");
		handyWorker = this.handyWorkerService.save(handyWorker);
		Assert.notNull(handyWorker);
	}
	
	@Test
	public void saveTest(){
		final HandyWorker handyWorker = this.handyWorkerService.findOne(1313);
		handyWorker.setName("Berto");
		this.handyWorkerService.save(handyWorker);
		Assert.notNull(this.handyWorkerService.findAll().contains(handyWorker));
	}

}
