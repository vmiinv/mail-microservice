package kz.edev.mailer.controller;

import kz.edev.mailer.entity.MailInfo;
import kz.edev.mailer.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    MailService mailService;

    @PostMapping("")
    public String sendOrderInfo(@RequestBody MailInfo mail) {
        System.out.println("===================================================================================================");
        System.out.println(mail.toString());
        System.out.println("===================================================================================================");
        return mailService.sendEmail(mail);
    }

}
