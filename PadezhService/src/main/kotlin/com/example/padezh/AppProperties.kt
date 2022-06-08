package com.example.padezh

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration

@Configuration
@ConfigurationProperties(value = "server")
class AppProperties {
    var token: String? = null
}