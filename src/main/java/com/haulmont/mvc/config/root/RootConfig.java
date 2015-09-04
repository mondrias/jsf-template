package com.haulmont.mvc.config.root;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.haulmont.mvc.config.security")
public class RootConfig {

}