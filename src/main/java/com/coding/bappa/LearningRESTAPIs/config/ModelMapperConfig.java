package com.coding.bappa.LearningRESTAPIs.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        // Optionally configure strict matching
        mapper.getConfiguration().setSkipNullEnabled(true);
        return mapper;
    }
}
