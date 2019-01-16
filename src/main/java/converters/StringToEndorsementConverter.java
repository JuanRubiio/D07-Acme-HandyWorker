
package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.EndorsementRepository;
import domain.Endorsement;

@Component
@Transactional
public class StringToEndorsementConverter implements Converter<String, Endorsement> {

	@Autowired
	EndorsementRepository	EndorsementRepository;


	@Override
	public Endorsement convert(final String text) {
		Endorsement res;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else {
				id = Integer.valueOf(text);
				res = this.EndorsementRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}