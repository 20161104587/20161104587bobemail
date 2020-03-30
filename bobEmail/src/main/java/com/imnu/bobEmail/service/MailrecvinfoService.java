package com.imnu.bobEmail.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.imnu.bobEmail.pojo.Mailinfo;
import com.imnu.bobEmail.pojo.Mailrecvinfo;

@Service
public interface MailrecvinfoService {

	void saveEmail(Mailrecvinfo mailrecvinfo);

	void updateEmailstate(int parseInt, int state);

	void updateEmailinformation(Integer mailid, Integer id);

	void updateEmaireadfalg(int parseInt, int parseInt2);



}
