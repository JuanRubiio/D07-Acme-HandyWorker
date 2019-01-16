
package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.MessageBoxRepository;
import domain.MessageBox;

@Component
@Transactional
public class StringToMessageBoxConverter implements Converter<String, MessageBox> {

	@Autowired
	MessageBoxRepository	messageBoxRepository;


	@Override
	public MessageBox convert(final String arg0) {
		MessageBox res;
		int id;

		try {
			if (StringUtils.isEmpty(arg0))
				res = null;
			else {
				id = Integer.valueOf(arg0);
				res = this.messageBoxRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}
