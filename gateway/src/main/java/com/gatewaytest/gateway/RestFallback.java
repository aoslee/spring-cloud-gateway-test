package com.gatewaytest.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestFallback {
    private final static Logger logger = LoggerFactory.getLogger(RestFallback.class);

    @RequestMapping("/aaafallback")
    @ResponseBody
    public ReturnResutl aaafallback() {
        ReturnResutl returnResutl = new ReturnResutl();
        returnResutl.setResult(9999);
        logger.warn("aaa is fall!");
        return returnResutl;
    }

}
