package com.imnu.bobEmail.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.imnu.bobEmail.pojo.Mailinfo;
import com.imnu.bobEmail.pojo.Mailrecvinfo;
import com.imnu.bobEmail.pojo.Users;
import com.imnu.bobEmail.service.DepartmentService;
import com.imnu.bobEmail.service.MailrecvinfoService;
import com.imnu.bobEmail.service.UsersService;


@Controller
@RequestMapping("/emailController")
public class EmailController {
	@Autowired
	private UsersService usersService;
	 @Autowired
	 private MailrecvinfoService mailrecvinfoService;
	 @Autowired
	 private DepartmentService departmentService;
	 
	//发送邮件
	@RequestMapping("/send")
	public ModelAndView send(Mailinfo mailinfo,MultipartFile file,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		Date d =new Date();
		String type=request.getParameter("type");
		String accept=request.getParameter("accept");
		//通过收件人邮箱 查询 其id
		Users acceptinformation =usersService.checkUser(accept);
		if(type.equals("save")) {
			int state =1; 
			email(mailinfo,file,state,d,acceptinformation.getId());
			System.out.println("发送完毕");
			mv.setViewName("redirect:/index.jsp");
		}else if(type.equals("draft")) {
			int state =2;
			email(mailinfo,file,state,d,acceptinformation.getId());
			System.out.println("草稿箱完毕");
			mv.setViewName("redirect:/index.jsp");
		}
			return mv;
	    }
	//发送 和存入草稿箱
	public void email(Mailinfo mailinfo,MultipartFile file,int state,Date d,int id) {
		mailinfo.setState(state); 
		mailinfo.setSendtime(d);
		mailinfo.setAttname(uploadMultipartFile(file));
		usersService.sendEmail(mailinfo);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(d);
		Mailinfo mail=usersService.checkEmail(dateString);
		Mailrecvinfo  mailrecvinfo =new Mailrecvinfo();
		mailrecvinfo.setMailid(mail.getMailid());
		mailrecvinfo.setReceiverid(id);
		mailrecvinfo.setState(state); 
		mailrecvinfo.setReadfalg(1);
		mailrecvinfoService.saveEmail(mailrecvinfo);
	}
	
	
	
	@RequestMapping("/sendgroupBumen")
	public ModelAndView sendgroupBumendo(Mailinfo mailinfo,MultipartFile file,String bumen,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		Date d =new Date();
		mailinfo.setState(1); 
		mailinfo.setSendtime(d);
		mailinfo.setAttname(uploadMultipartFile(file));
		mailinfo.setImportantflag(1);
		usersService.sendEmail(mailinfo);
		String[] split = bumen.split(",");
			for (String s:split) {
				List<Integer> list=usersService.checkbumenPeople(Integer.parseInt(s));
				for (int i=0;i<list.size();i++) {
					if(list.get(i)==mailinfo.getSenderid()) {
						continue;
					}
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateString = formatter.format(d);	
					Mailinfo mail=usersService.checkEmail(dateString);
					Mailrecvinfo  mailrecvinfo =new Mailrecvinfo();
					mailrecvinfo.setMailid(mail.getMailid());
					mailrecvinfo.setReceiverid(list.get(i));
					mailrecvinfo.setState(1);
					mailrecvinfo.setReadfalg(1);
					mailrecvinfoService.saveEmail(mailrecvinfo);
				}
			}			
		//}
		System.out.println("成功");
		    mv.setViewName("redirect:/index.jsp");
			return mv;
	    }
	
	
	
	@RequestMapping("/senduserpeople")
	public ModelAndView senduserpeople(String title,MultipartFile file,String people,String senderid,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		String body1=request.getParameter("body1");
		System.out.println("群发群发");
		Date d =new Date();
		Mailinfo mailinfo =new Mailinfo();
		mailinfo.setState(1); 
		mailinfo.setSendtime(d);
		mailinfo.setAttname(uploadMultipartFile(file));
		mailinfo.setImportantflag(1);
		mailinfo.setBody(body1);
		mailinfo.setTitle(title);
		mailinfo.setSenderid(Integer.parseInt(senderid));
		usersService.sendEmail(mailinfo);
		String[] split = people.split(",");
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		  String dateString = formatter.format(d);
		  Mailinfo  mail=usersService.checkEmail(dateString);
			for (String s:split) {
				if(Integer.parseInt(s)==mailinfo.getSenderid()) {
					continue;
				}
				  Mailrecvinfo mailrecvinfo =new Mailrecvinfo();
				  mailrecvinfo.setMailid(mail.getMailid());
				  mailrecvinfo.setReceiverid(Integer.parseInt(s));
				  mailrecvinfo.setState(1);
				  mailrecvinfo.setReadfalg(1);
				  mailrecvinfoService.saveEmail(mailrecvinfo);
			}
			mv.setViewName("redirect:/index.jsp");
			return mv;
	    }
	
	@RequestMapping("/outbox")
	public ModelAndView outbox(String senderid,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		    List<Mailinfo> mailinfo= usersService.selectoutbox(Integer.parseInt(senderid));
		    System.out.println(mailinfo);
		    session.setAttribute("outbox", mailinfo);
			mv.setViewName("redirect:/outbox.jsp");
			return mv;
	    }
	
	
	@RequestMapping("/groupemail")
	public ModelAndView groupemail(String userid,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		System.out.println("群发邮件发送");
		    List<Mailinfo> mailinfo= usersService.groupemail(Integer.parseInt(userid));
		    System.out.println(mailinfo);
		    session.setAttribute("outboxgroup", mailinfo);
			mv.setViewName("redirect:/outboxgroup.jsp");
			return mv;
	    }
	
	
	@RequestMapping("/inbox")
	public ModelAndView inbox(String recvid,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		    List<Mailinfo> mailinfo= usersService.selectinbox(Integer.parseInt(recvid));
		    session.setAttribute("inbox", mailinfo);
			mv.setViewName("redirect:/inbox.jsp");
			return mv;
	    }
	
	@RequestMapping("/draft")
	public ModelAndView draft(String userid,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		    List<Mailinfo> mailinfo= usersService.selectdraft(Integer.parseInt(userid));
		    session.setAttribute("draft", mailinfo);
			mv.setViewName("redirect:/draft.jsp");
			return mv;
	    }
	
	@RequestMapping("/draftsendEmail")
	public void draftsendEmail(String emailid,String userid,HttpSession session,HttpServletRequest request)  {
		int state=1;
		usersService.updateEmailstate(Integer.parseInt(emailid),state);
		mailrecvinfoService.updateEmailstate(Integer.parseInt(emailid),state);
	    }
	
	@RequestMapping("/deletefordustbin")
	public void deletefordustbin(String emailid,String userid,String type,HttpSession session,HttpServletRequest request)  {
	   int state =3;
		System.out.println(emailid);
		System.out.println("删除进来了");
		System.out.println(type);
		if(type.equals("inbox")) {
			mailrecvinfoService.updateEmailstate(Integer.parseInt(emailid),state);
		}else if(type.equals("outbox")) {
			 usersService.updateEmailstate(Integer.parseInt(emailid),state);
		}else if(type.equals("draft")) {
			 usersService.updateEmailstate(Integer.parseInt(emailid),state);
			 mailrecvinfoService.updateEmailstate(Integer.parseInt(emailid),state);
		}    
	    }
	
	
		@RequestMapping("/selectdustbin")
		public ModelAndView selectdustbin(String userid,HttpSession session,HttpServletRequest request)  {
			ModelAndView mv=new ModelAndView();
			    List<Mailinfo> dustbinOutbox= usersService.selectdustbinOutbox(Integer.parseInt(userid));
			    List<Mailinfo> dustbinInbox= usersService.selectdustbinInbox(Integer.parseInt(userid));
			    session.setAttribute("dustbinOutbox", dustbinOutbox);
			    session.setAttribute("dustbinInbox", dustbinInbox);
				mv.setViewName("redirect:/dustbin.jsp");
				return mv;
		    }
		
		
		@RequestMapping("/reduction")
		public void reduction(String emailid,String userid,String type,HttpSession session,HttpServletRequest request)  {
			int state=1;
				if(type.equals("outbox")) {
					usersService.updateEmailstate(Integer.parseInt(emailid),state);
				}else if(type.equals("inbox")){
					mailrecvinfoService.updateEmailstate(Integer.parseInt(emailid),state);
				}
		    }
		
		@RequestMapping("/reply")
		public void reply(String emailid,String userid,HttpSession session,HttpServletRequest request)  {
			mailrecvinfoService.updateEmaireadfalg(Integer.parseInt(emailid),Integer.parseInt(userid));
				
		    }
	
	@RequestMapping("/upload")
	public String uploadMultipartFile(MultipartFile file) {
		String filename = file.getOriginalFilename();	
		try {
			File dest = new File("E:/mvc/uploads/");
			 if (!dest.exists()) { 
				 dest.mkdirs(); 
	             }
	          FileUtils.copyInputStreamToFile(file.getInputStream(), new File(dest,filename)); 
			return filename;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "error";
	}

}
