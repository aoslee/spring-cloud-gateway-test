package com.gatewaytest.aaa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/aaa/v1/")
public class AaaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AaaApplication.class, args);
    }

    @RequestMapping(value = "users", method = RequestMethod.GET)
    @ResponseBody
    public ReturnResutl getUsers(
            @RequestParam(value = "id", required = false) String id
    ) {
        ReturnResutl returnResutl = new ReturnResutl();
        returnResutl.setResult(1000);
        return returnResutl;
    }
}
