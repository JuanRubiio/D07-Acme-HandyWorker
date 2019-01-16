package converters;


import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.FixUpTask;

@Component
@Transactional	
public class FixUpTaskToStringConverter implements Converter<FixUpTask,String> {

	@Override
	public String convert(FixUpTask fixUpTask) {
		String res;
		
		if(fixUpTask==null){
			res=null;
		}else{
			res = String.valueOf(fixUpTask.getId());
		}
		
		return res;
	}
	
}
