package com.online.bidding.configuration;

import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class DozerConfig {


    public DozerBeanMapper dozerBeanMapper(String mappingFile){

        List<String> mappingFiles = new ArrayList<String>();
        mappingFiles.add(mappingFile);

        DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();
        log.info("adding dozer mapping file {}", mappingFile);
        dozerBeanMapper.setMappingFiles(mappingFiles);

        return dozerBeanMapper;
    }

    @Bean(destroyMethod = "destroy")
    public DozerBeanMapper dozerBeanMapper(){
        return this.dozerBeanMapper("dozer-mapping.xml");
    }

}
