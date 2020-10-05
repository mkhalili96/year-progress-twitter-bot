package net.msina.twbot.yearprogress.model.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBeanProvider {

    @Bean
    public RestTemplate restTemplateProvider() {
        return new RestTemplate();
    }
}
