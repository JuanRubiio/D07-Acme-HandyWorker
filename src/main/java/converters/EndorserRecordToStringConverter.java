
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.EndorserRecord;

@Component
@Transactional
public class EndorserRecordToStringConverter implements Converter<EndorserRecord, String> {

	@Override
	public String convert(final EndorserRecord EndorserRecord) {
		String result;

		if (EndorserRecord == null)
			result = null;
		else
			result = String.valueOf(EndorserRecord.getId());

		return result;
	}
}
