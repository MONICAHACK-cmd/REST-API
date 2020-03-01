package com.hackathon.controller;

import com.hackathon.service.SendMailService;
import com.hackathon.util.RequestKeys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@ComponentScan("com")
public class SendMailController {

    @Autowired
    SendMailService mailService;

    @RequestMapping("/test")
    String test() {
        return "Service is working fine !";
    }

    @RequestMapping(value = RequestKeys.SENDMAIL, method = RequestMethod.POST)
    public String sendEmail(@RequestBody String jsonString) {
        try {
            return mailService.sendEmailToUser(jsonString);
        } catch (Exception e) {
            log.error("Caught Exception exception : "
                    + e);
            return String.valueOf(e);
        }
    }
}
