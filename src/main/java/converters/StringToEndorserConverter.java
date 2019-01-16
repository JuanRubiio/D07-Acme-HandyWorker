
package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.EndorserRepository;
import domain.Endorser;

@Component
@Transactional
public class StringToEndorserConverter implements Converter<String, Endorser> {

	@Autowired
	EndorserRepository	EndorserRepository;


	@Override
	public Endorser convert(final String text) {
		Endorser res;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else {
				id = Integer.valueOf(text);
				res = this.EndorserRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}