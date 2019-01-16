
package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.ConfigurationRepository;
import domain.Configuration;

@Component
@Transactional
public class StringToConfigurationConverter implements Converter<String, Configuration> {

	@Autowired
	ConfigurationRepository	configurationRepository;


	@Override
	public Configuration convert(final String arg0) {
		Configuration res;
		int id;

		try {
			if (StringUtils.isEmpty(arg0))
				res = null;
			else {
				id = Integer.valueOf(arg0);
				res = this.configurationRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}
