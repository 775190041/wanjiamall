package com.nf.wanjiamall.entity;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Component
@Data
@ConfigurationProperties(prefix = "wanjiamall.express")
public class ExpressProperties {
    private boolean enable;
    private String appId;
    private String appKey;
    private List<Map<String, String>> vendors = new ArrayList<>();

}