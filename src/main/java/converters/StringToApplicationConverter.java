package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import domain.Application;

import repositories.ApplicationRepository;

public class StringToApplicationConverter implements Converter<String,Application>{

	@Autowired
	ApplicationRepository applicationRepository;
	
	@Override
	public Application convert(String text) {
		Application res;
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
