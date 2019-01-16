
package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.SponsorRepository;
import domain.Sponsor;

@Component
@Transactional
public class StringToSponsorConverter implements Converter<String, Sponsor> {

	@Autowired
	SponsorRepository	SponsorRepository;


	@Override
	public Sponsor convert(final String text) {
		Sponsor res;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else {
				id = Integer.valueOf(text);
				res = this.SponsorRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}