package com.easy.framework.web;


import com.easy.framework.web.config.DateTimeConfig;
import com.easy.framework.web.config.DateTimeConvertPrimaryConfig;
import com.easy.framework.web.exception.GlobalExceptionHandler;
import com.easy.framework.web.exception.SentinelBlockExceptionHandler;
import com.easy.framework.web.result.InitializingAdviceDecorator;
import com.easy.framework.web.swagger.SwaggerConfiguration;
import com.easy.framework.web.swagger.SwaggerShortcutController;
import com.easy.framework.web.transform.TransformConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.easy.framework.**.web")
@Import({SwaggerConfiguration.class, InitializingAdviceDecorator.class,
        GlobalExceptionHandler.class, SentinelBlockExceptionHandler.class,
        DateTimeConfig.class, SwaggerShortcutController.class, TransformConfig.class, DateTimeConvertPrimaryConfig.class})
public class WebAutoConfig {

}
