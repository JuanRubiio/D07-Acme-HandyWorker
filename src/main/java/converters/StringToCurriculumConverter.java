package converters;

import javax.transaction.Transactional;

import domain.Curriculum;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Category;
import repositories.CurriculumRepository;

@Component
@Transactional
public class StringToCurriculumConverter implements Converter<String, Curriculum>{

    @Autowired
    CurriculumRepository curriculumRepository;


    public Curriculum convert(String text){
        Curriculum result;
        int id;

        try{
            if(StringUtils.isEmpty(text)){
                result = null;
            }else{
                id=Integer.valueOf(text);
                result= curriculumRepository.findOne(id);
            }

        }catch (Throwable oops) {
            throw new IllegalArgumentException(oops);
        }


        return result;

    }




}
