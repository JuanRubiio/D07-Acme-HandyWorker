
package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.SpamRepository;
import domain.Spam;

@Component
@Transactional
public class StringToSpamConverter implements Converter<String, Spam> {

	@Autowired
	SpamRepository	spamRepository;


	@Override
	public Spam convert(final String arg0) {
		Spam res;
		int id;

		try {
			if (StringUtils.isEmpty(arg0))
				res = null;
			else {
				id = Integer.valueOf(arg0);
				res = this.spamRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}
