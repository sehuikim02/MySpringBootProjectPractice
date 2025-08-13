package com.rookies4.myspringbootlab.property;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myprop")
@Getter
public class MyPropProperties {
    private String username;
    private int port;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
