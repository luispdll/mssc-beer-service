package io.thinkingcode.msscbeerservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("local-discovery")
@EnableDiscoveryClient
@Configuration
public class LocalDiscovery {
}