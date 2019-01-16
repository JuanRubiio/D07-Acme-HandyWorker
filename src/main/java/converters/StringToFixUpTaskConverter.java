package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import domain.FixUpTask;

import repositories.FixUpTaskRepository;

public class StringToFixUpTaskConverter implements Converter<String,FixUpTask>{

	@Autowired
	FixUpTaskRepository applicationRepository;
	
	@Override
	public FixUpTask convert(String text) {
		FixUpTask res;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				res=null;
			}else{
				id = Integer.valueOf(text);
				res = applicationRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return res;
	}
}
