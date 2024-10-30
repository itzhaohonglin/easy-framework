package com.easy.framework.web.safety;

import com.easy.framework.web.safety.sign.SignAspect;
import com.easy.framework.web.safety.sign.SignExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SignAspect.class, SignExceptionHandler.class})
public class SignAutoConfig {

}
