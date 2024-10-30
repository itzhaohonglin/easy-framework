package com.easy.framework.rocketmq;


import com.easy.framework.rocketmq.annotation.MessageQueueScan;
import com.easy.framework.rocketmq.config.AliMqConfiguration;
import com.easy.framework.rocketmq.config.OpenSourceMqConfiguration;
import com.easy.framework.rocketmq.config.RocketMqConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@MessageQueueScan("com.easy.**.mq.**")
@EnableConfigurationProperties(RocketMqConfigurationProperties.class)

@Import({AliMqConfiguration.class, OpenSourceMqConfiguration.class})
public class RocketMqAutoConfiguration {

}
