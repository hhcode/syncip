package com.huang.syncip;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@RestController
public class SyncIpController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SyncIpController.class);
    private static String oldIp;
    private static String ipChangeShell = "sh /etc/nginx/changeIp.sh";


    static {
        try {
            Process process = Runtime.getRuntime().exec("cat /etc/nginx/ip");
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            oldIp = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/syncip")
    public String syncIp(@RequestParam(value = "ip") String newIp) throws Exception {

        if (!StringUtils.isEmpty(newIp) && !oldIp.equals(newIp.trim())) {
            LOGGER.info("newIp ： {}  oldIp : {}", newIp, oldIp);
            Runtime.getRuntime().exec(ipChangeShell + " " + oldIp + " " + newIp);
            oldIp = newIp;
            LOGGER.info("change ip success... newIp : {}", newIp);
            return "change ip success...";
        } else {
            LOGGER.info("ip not change... ip : {}", newIp);
            return "ip not change...";
        }
    }

}
