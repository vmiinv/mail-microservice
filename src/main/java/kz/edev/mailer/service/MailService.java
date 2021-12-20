package kz.edev.mailer.service;

import kz.edev.mailer.entity.MailInfo;
import kz.edev.mailer.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class MailService {

    @Qualifier("getJavaMailSender")
    @Autowired
    public JavaMailSender emailSender;

    public String sendEmail(MailInfo mail) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mail.getEmail());
        message.setSubject("Order Info");
        StringBuilder text = new StringBuilder();
        for (Product product : mail.getProducts()) {
            text.append("Product name: ").append(product.getTitle()).append(", price: $").append(product.getPrice()).append("\n");
        }
        text.append("Total: $" + mail.getTotal());
        message.setText(text.toString());
        this.emailSender.send(message);
        return "Email Sent!";
    }
}
