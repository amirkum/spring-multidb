package ru.crynet.spring.multidb.configuration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "app")
@Configuration
public class AppProperties {
    private Map<Integer, String> statdb;
    private String paysdb;

    public Map<Integer, String> getStatdb() {
        return statdb;
    }

    public void setStatdb(Map<Integer, String> statdb) {
        this.statdb = statdb;
    }

    public String getPaysdb() {
        return paysdb;
    }

    public void setPaysdb(String paysdb) {
        this.paysdb = paysdb;
    }
}
