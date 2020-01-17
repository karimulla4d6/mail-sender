package com.example.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.app.model.RequestDTO;
import com.example.app.model.ResponseDto;

@Service
public class MailSenderBoot {

	@Autowired
	private JavaMailSender mailSender;
	
	
	
	
	public ResponseDto send(RequestDTO requestDTO) {
		ResponseDto responseDto = new ResponseDto();		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(requestDTO.getFrom());
		message.setTo(requestDTO.getTo());
		message.setSubject(requestDTO.getSubject());
		message.setText(requestDTO.getText());
		try {
			mailSender.send(message);
			responseDto.setMessage("Mail sent Successfully");
			responseDto.setStatus("200 Ok");
		}catch(Exception e) {
			System.err.println(e.getMessage());
			responseDto.setMessage("Mail not sent");
		}
		return responseDto;
	}
}
