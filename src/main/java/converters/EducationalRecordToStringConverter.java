
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.EducationalRecord;

@Component
@Transactional
public class EducationalRecordToStringConverter implements Converter<EducationalRecord, String> {

	@Override
	public String convert(final EducationalRecord educationalRecord) {
		String result;

		if (educationalRecord == null)
			result = null;
		else
			result = String.valueOf(educationalRecord.getId());

		return result;
	}
}
