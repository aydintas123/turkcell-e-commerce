package kodlama.io.ecommerce.MapperConfig;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Component
public class ModelMapperConfig {
    @Bean
    public ModelMapper getMapper(){
        return new ModelMapper();
    }
}
