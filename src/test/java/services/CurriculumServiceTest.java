
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.Curriculum;
import domain.PersonalRecord;

// NOTA: ES NECESARIO POPULAR ANTES DE EJECUTAR EL TEST, PARA PREVENIR POSIBLES FALLOS

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class CurriculumServiceTest extends AbstractTest {

	@Autowired
	private CurriculumService			curriculumService;
	@Autowired
	private PersonalRecordService		personalRecordService;
	@Autowired
	private MiscellaneousRecordService	miscellaneousRecordService;
	@Autowired
	private EndorserRecordService		endorserRecordService;
	@Autowired
	private ProfessionalRecordService	professionalRecordService;
	@Autowired
	private EducationalRecordService	educationalRecordService;
	@Autowired
	private HandyWorkerService			handyWorkerService;
	@Autowired
	private UtilitiesService			utilitiesService;


	//	@Test
	//	public void createCurriculumTest() {
	//		final HandyWorker handyWorker1 = this.handyWorkerService.create();
	//		handyWorker1.setAddress("adres");
	//		this.authenticate("handyWorker1");
	//
	//		final String ticker = this.utilitiesService.generateTicker();
	//		final PersonalRecord personalR1 = this.personalRecordService.create();
	//		final EndorserRecord endorserR1 = this.endorserRecordService.create();
	//		final EducationalRecord educationalR1 = this.educationalRecordService.create();
	//		final ProfessionalRecord professionalR1 = this.professionalRecordService.create();
	//		final MiscellaneousRecord miscellaneousR1 = this.miscellaneousRecordService.create();
	//
	//		final Collection<EndorserRecord> endorserR = null;
	//		final Collection<EducationalRecord> educationalR = null;
	//		final Collection<ProfessionalRecord> professionalR = null;
	//		final Collection<MiscellaneousRecord> miscellaneousR = null;
	//
	//		endorserR.add(endorserR1);
	//		educationalR.add(educationalR1);
	//		professionalR.add(professionalR1);
	//		miscellaneousR.add(miscellaneousR1);
	//
	//		final Curriculum before = this.curriculumService.create();
	//
	//		before.setTicker(ticker);
	//		before.setPersonalRecord(personalR1);
	//		before.setEndorserRecords(endorserR);
	//		before.setEducationalRecords(educationalR);
	//		before.setProfessionalRecords(professionalR);
	//		before.setMiscellaneousRecords(miscellaneousR);
	//
	//		final Integer aux = this.curriculumService.save(before).getId();
	//
	//		final Curriculum later = this.curriculumService.findOne(aux);
	//
	//		Assert.isTrue(later.getTicker().equals(ticker));
	//		Assert.isTrue(later.getPersonalRecord().equals(personalR1));
	//		Assert.isTrue(later.getEndorserRecords().equals(endorserR));
	//		Assert.isTrue(later.getEducationalRecords().equals(educationalR));
	//		Assert.isTrue(later.getProfessionalRecords().equals(professionalR));
	//		Assert.isTrue(later.getMiscellaneousRecords().equals(miscellaneousR));
	//	}
	//		super.authenticate("handyWorker1");
	//		
	//		final PersonalRecord p1 = this.personalRecordService.create();
	//		final MiscellaneousRecord p2 = this.miscellaneousRecordService.create();
	//		final EndorserRecord p3 = this.endorserRecordService.create();
	//		final EducationalRecord p4 = this.educationalRecordService.create();
	//		final ProfessionalRecord p5 = this.professionalRecordService.create();
	//		
	//		final Collection<EducationalRecord> edr = new Collection<EducationalRecord>();
	//		final Collection<ProfessionalRecord> profr = this.professionalRecordService.create();
	//		final Collection<MiscellaneousRecord> misr = this.miscellaneousRecordService.create();
	//		final Collection<EndorserRecord> endr = this.endorserRecordService.create();
	//		
	//
	//		final Curriculum before = this.curriculumService.create();
	//		before.setPersonalRecord(p1);
	//		final Integer aux = this.curriculumService.save(before).getId();
	//		final Curriculum later = this.curriculumService.findOne(aux);
	//		Assert.isTrue(later.getPersonalRecord().equals(p1));
	//	}
	//----------------------------------
	//	@Test
	//	public void createCurriculumTest() {
	//		this.authenticate("handyWorker1");
	//		final Curriculum curriculum = this.curriculumService.create();
	//		this.curriculumService.save(curriculum);
	//	}
	//		super.authenticate("handyWorker1");
	//		
	//		final PersonalRecord p1 = this.personalRecordService.create();
	//		final MiscellaneousRecord p2 = this.miscellaneousRecordService.create();
	//		final EndorserRecord p3 = this.endorserRecordService.create();
	//		final EducationalRecord p4 = this.educationalRecordService.create();
	//		final ProfessionalRecord p5 = this.professionalRecordService.create();
	//		
	//		final Collection<EducationalRecord> edr = new Collection<EducationalRecord>();
	//		final Collection<ProfessionalRecord> profr = this.professionalRecordService.create();
	//		final Collection<MiscellaneousRecord> misr = this.miscellaneousRecordService.create();
	//		final Collection<EndorserRecord> endr = this.endorserRecordService.create();
	//		
	//
	//		final Curriculum before = this.curriculumService.create();
	//		before.setPersonalRecord(p1);
	//		final Integer aux = this.curriculumService.save(before).getId();
	//		final Curriculum later = this.curriculumService.findOne(aux);
	//		Assert.isTrue(later.getPersonalRecord().equals(p1));
	//	}
	@Test(expected = IllegalArgumentException.class)
	public void deleteCurriculumTest() {
		final Curriculum curriculum = this.curriculumService.findOne(273);
		this.curriculumService.delete(curriculum);
		this.curriculumService.findOne(273);
	}
	@Test
	public void findAllPersonalRecordTest() {
		final Collection<PersonalRecord> pr = this.personalRecordService.findAll();
		Assert.isTrue(!pr.isEmpty());
	}
}
