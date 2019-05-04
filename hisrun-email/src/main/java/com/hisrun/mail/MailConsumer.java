package com.hisrun.mail;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailConsumer {

	@Autowired
	private JavaMailSender sender;

	@GetMapping("/send")
	public String send() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("zhentao.yang@newtouch.cn");
		message.setTo("zhentao.yang@newtouch.cn");
		message.setSubject("这是一份测试邮件");
		message.setText("请点击注册");
		sender.send(message);
		return "1";
	} 
	@RabbitHandler
    public void process(String hello){
        System.out.println("Receiver:" + hello);
    }

	
	
	
}
