package com.atguigu.vod.utils;

import com.sun.org.apache.xpath.internal.objects.XString;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantPropertiesUtils implements InitializingBean {

    @Value("${aliyun.vod.file.keyid}")
    private String keyId;

    @Value("${aliyun.vod.file.secret}")
    private String keySecret;

    public static String ACCESS_KEY_ID;

    public static String ACCESS_SECRET;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID = keyId;
        ACCESS_SECRET = keySecret;
    }
}
