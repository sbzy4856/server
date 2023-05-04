package org.server.controller;

import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;
@RestController
public class emailController {
    @Resource
    private JavaMailSender javaMailSender;
//    @Value("${spring.mail.username}")
//    private String sender;
//    @Component
//    public class SendEmail {
//        public String sendEmail(String email){
//            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//            simpleMailMessage.setSubject("hkdsg.com");
//            simpleMailMessage.setText("注意查收。验证码为"+captcha);
//            simpleMailMessage.setTo(email);
//            simpleMailMessage.setFrom(sender);
//            javaMailSender.send(simpleMailMessage);
//            return String.valueOf(new Random().nextInt(89999) + 10000);
//        }
//    }

    @RequestMapping("/sendEmail")
    @ResponseBody
    public boolean sendEmail(@RequestParam("email") String email) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("1127023277@qq.com");
        msg.setBcc();
        msg.setTo(email);
        msg.setSubject("验证码");
        msg.setText("606db82e-2af4-4a3f-bf21-e138dba626f8");
        try {
            javaMailSender.send(msg);
        } catch (MailException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
        return true;
    }
}
