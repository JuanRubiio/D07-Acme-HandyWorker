
package services;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.Actor;
import domain.Administrator;
import domain.MessageBox;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class MessageBoxServiceTest extends AbstractTest {

	@Autowired
	private ActorService			actorService;

	@Autowired
	private AdministratorService	administratorService;

	@Autowired
	private MessageBoxService		messageboxService;


	@Test
	public void addDefaultBoxesTest() {

		final Administrator admin = this.administratorService.create();
		admin.setName("Raul");
		admin.setMiddleName("Castri");
		admin.setSurname("Suprimo");
		admin.setPhone("www.photo.es");
		admin.setEmail("pipo@hotmail.com");
		admin.setAddress("La botica");
		admin.setPhone("666666666");
		admin.setSuspicious(false);
		final Administrator res = this.administratorService.save(admin);
		res.setMessageBoxes(this.messageboxService.addDefaultMessageBoxs(res));

		final Administrator res2 = this.administratorService.save(res);

		Assert.notNull(res2);
	}

	@Test
	public void createNewBox() {
		super.authenticate("administrator1");
		final Actor admin = this.actorService.getPrincipal();
		final MessageBox newbox = this.messageboxService.create();
		newbox.setName("prueba");
		admin.getMessageBoxes().add(newbox);
		final Actor res = this.actorService.save(admin);

		Assert.notNull(res);
	}

}