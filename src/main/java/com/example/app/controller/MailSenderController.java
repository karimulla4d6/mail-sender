package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.model.RequestDTO;
import com.example.app.model.ResponseDto;
import com.example.app.service.MailSenderBoot;

@RestController
@RequestMapping(path = "/mail")
public class MailSenderController {

	@Autowired
	private MailSenderBoot senderBoot;

	@PostMapping(path = "/send",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = MediaType.APPLICATION_JSON_VALUE )
	private ResponseEntity<ResponseDto> send(@RequestBody RequestDTO requestDTO){
		
		
		System.out.println("I am in java class");
		ResponseDto responseDto = senderBoot.send(requestDTO); 
		if((responseDto.getMessage()).equals("Mail sent Successfully"))
		return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
		else
		return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.BAD_GATEWAY);
	}

}
