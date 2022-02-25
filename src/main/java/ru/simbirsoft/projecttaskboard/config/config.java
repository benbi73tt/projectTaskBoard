package ru.simbirsoft.projecttaskboard.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("ru.simbirsoft")
public class config {

    @Bean("PageName")
    @Primary
    public String getPageName(){
        return "Table board";
    }
}
