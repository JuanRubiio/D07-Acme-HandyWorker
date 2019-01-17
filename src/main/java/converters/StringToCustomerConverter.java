package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import repositories.CustomerRepository;

import domain.Customer;

public class StringToCustomerConverter implements Converter<String ,Customer>{

	@Autowired
	CustomerRepository CustomerRepository;
	
	@Override
	public Customer convert(String text) {
		Customer res;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				res=null;
			}else{
				id = Integer.valueOf(text);
				res = CustomerRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return res;
	}
	
}
