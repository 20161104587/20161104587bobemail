package com.imnu.bobEmail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.bobEmail.mapper.MailrecvinfoMapper;
import com.imnu.bobEmail.pojo.Mailinfo;
import com.imnu.bobEmail.pojo.MailinfoExample;
import com.imnu.bobEmail.pojo.Mailrecvinfo;
import com.imnu.bobEmail.pojo.MailrecvinfoExample;

@Service
@Transactional
public class MailrecvinfoServiceImp implements MailrecvinfoService {
	@Autowired
	private MailrecvinfoMapper mailrecvinfoMapper;
	
	@Override
	public void saveEmail(Mailrecvinfo mailrecvinfo) {
		
		mailrecvinfoMapper.insertSelective(mailrecvinfo);
	}

	@Override
	public void updateEmailstate(int parseInt, int state) {
		MailrecvinfoExample mailrecvinfoExample = new MailrecvinfoExample();
		mailrecvinfoExample.createCriteria().andMailidEqualTo(parseInt);
		Mailrecvinfo mailrecvinfo =new Mailrecvinfo();
		mailrecvinfo.setState(state);
		mailrecvinfoMapper.updateByExampleSelective(mailrecvinfo, mailrecvinfoExample);
		
	}

	//根据  mailid 修改 收件人信息 sql语句错误 待跟新
	@Override
	public void updateEmailinformation(Integer mailid, Integer id) {
	
		mailrecvinfoMapper.updateRevEmailid(mailid,id);
	
		
	}

	@Override
	public void updateEmaireadfalg(int parseInt, int parseInt2) {
		mailrecvinfoMapper.updateEmaireadfalg(parseInt,parseInt2);
		
	}





}
