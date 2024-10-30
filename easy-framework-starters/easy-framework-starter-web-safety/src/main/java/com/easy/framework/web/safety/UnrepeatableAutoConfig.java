package com.easy.framework.web.safety;


import com.easy.framework.redis.RedisClient;
import com.easy.framework.web.safety.repeat.UnRepeatableRequestAspect;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnBean(RedisClient.class)
@Import({UnRepeatableRequestAspect.class})
public class UnrepeatableAutoConfig {
}
