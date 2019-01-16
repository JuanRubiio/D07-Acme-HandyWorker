
package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.TutorialRepository;
import domain.Tutorial;

@Component
@Transactional
public class StringToTutorialConverter implements Converter<String, Tutorial> {

	@Autowired
	TutorialRepository	TutorialRepository;


	@Override
	public Tutorial convert(final String text) {
		Tutorial res;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else {
				id = Integer.valueOf(text);
				res = this.TutorialRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}