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
			//state为2 时 是草稿箱
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
		//文件上传
		mailinfo.setAttname(uploadMultipartFile(file));
		usersService.sendEmail(mailinfo);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(d);	
		//根据发送时间将mailinfo的 id取出 存入到收件表
		Mailinfo mail=usersService.checkEmail(dateString);
	
		//System.out.println(mail.getBody());
		//赋值数据 插入到 recvinfo中 
		Mailrecvinfo  mailrecvinfo =new Mailrecvinfo();
		mailrecvinfo.setMailid(mail.getMailid());
		mailrecvinfo.setReceiverid(id);
		mailrecvinfo.setState(state); //recvinfo表中 static 1为正常
		mailrecvinfo.setReadfalg(1);//recvinfo 阅读标志 1为 未读
		mailrecvinfoService.saveEmail(mailrecvinfo);
	}
	//部门群发
	
	
	@RequestMapping("/sendgroupBumen")
	public ModelAndView sendgroupBumendo(Mailinfo mailinfo,MultipartFile file,String bumen,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		Date d =new Date();
		//String[] split = bumen.split(",");
	//	for (String s:split) {
		mailinfo.setState(1); 
		mailinfo.setSendtime(d);
		mailinfo.setAttname(uploadMultipartFile(file));
		mailinfo.setImportantflag(1); //测试 1 为群发
		usersService.sendEmail(mailinfo);
			List<Integer> list=usersService.checkbumenPeople(Integer.parseInt(bumen));
			for (int i=0;i<list.size();i++) {
				if(list.get(i)==mailinfo.getSenderid()) {
					i=i+1;
				}
				//存入收件箱表 
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dateString = formatter.format(d);	
				//根据发送时间将mailinfo的 id取出 存入到收件表
				Mailinfo mail=usersService.checkEmail(dateString);
				//System.out.println(mail.getBody());
				//赋值数据 插入到 recvinfo中 
				Mailrecvinfo  mailrecvinfo =new Mailrecvinfo();
				mailrecvinfo.setMailid(mail.getMailid());
				mailrecvinfo.setReceiverid(list.get(i));
				mailrecvinfo.setState(1); //recvinfo表中 static 1为正常
				mailrecvinfo.setReadfalg(1);//recvinfo 阅读标志 1为 未读
				mailrecvinfoService.saveEmail(mailrecvinfo);
				//departmentService.insertgrouprecv(mail.getMailid(),mailinfo.getSenderid(),list.get(i),d);	
			}			
		//}
		System.out.println("giao!!!!!!!!!");
		    mv.setViewName("redirect:/index.jsp");
			return mv;
	    }
	
	
	
	@RequestMapping("/senduserpeople")
	public ModelAndView senduserpeople(String title,MultipartFile file,String people,String senderid,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		String body1=request.getParameter("body1");
		System.out.println("群发群发");
		Date d =new Date();
		//String[] split = bumen.split(",");
	//	for (String s:split) {
		Mailinfo mailinfo =new Mailinfo();
		mailinfo.setState(1); 
		mailinfo.setSendtime(d);
		mailinfo.setAttname(uploadMultipartFile(file));
		mailinfo.setImportantflag(1); //测试 1 为群发
		mailinfo.setBody(body1);
		mailinfo.setTitle(title);
		mailinfo.setSenderid(Integer.parseInt(senderid));
		usersService.sendEmail(mailinfo);
		String[] split = people.split(",");
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		  String dateString = formatter.format(d); //根据发送时间将mailinfo的 id取出 存入到收件表
		  Mailinfo  mail=usersService.checkEmail(dateString);
			for (String s:split) {
				if(Integer.parseInt(s)==mailinfo.getSenderid()) {
					continue;
				}
				  //System.out.println(mail.getBody()); 
				  //赋值数据 插入到 recvinfo中
				  Mailrecvinfo mailrecvinfo =new Mailrecvinfo();
				  mailrecvinfo.setMailid(mail.getMailid());
				  mailrecvinfo.setReceiverid(Integer.parseInt(s));
				  mailrecvinfo.setState(1);
				  //recvinfo表中 static 1为正常 
				  mailrecvinfo.setReadfalg(1);
				  //recvinfo 阅读标志 1为 未读
				  mailrecvinfoService.saveEmail(mailrecvinfo);
			}
			mv.setViewName("redirect:/index.jsp");
		
		  //存入收件箱表 
		 
		 
				//departmentService.insertgrouprecv(mail.getMailid(),mailinfo.getSenderid(),list.get(i),d);	
				
		//}
		/*
		 * System.out.println("giao!!!!!!!!!");
		 * System.out.println(mailinfo.getSenderid());
		 * System.out.println(mailinfo.getBody()); System.out.println(bumen);
		 * System.out.println();
		 */
			return mv;
	    }
	//发件箱
	@RequestMapping("/outbox")
	public ModelAndView outbox(String senderid,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		    List<Mailinfo> mailinfo= usersService.selectoutbox(Integer.parseInt(senderid));
		    System.out.println(mailinfo);
		    session.setAttribute("outbox", mailinfo);
			mv.setViewName("redirect:/outbox.jsp");
			return mv;
	    }
	
	//群发邮件 发件箱
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
	//收件箱
	
	@RequestMapping("/inbox")
	public ModelAndView inbox(String recvid,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		    List<Mailinfo> mailinfo= usersService.selectinbox(Integer.parseInt(recvid));
		   // int listSize = mailinfo.size(); 可统计收件箱有多少数据
		    session.setAttribute("inbox", mailinfo);
			mv.setViewName("redirect:/inbox.jsp");
			return mv;
	    }
	//草稿箱draft
	@RequestMapping("/draft")
	public ModelAndView draft(String userid,HttpSession session,HttpServletRequest request)  {
		ModelAndView mv=new ModelAndView();
		    List<Mailinfo> mailinfo= usersService.selectdraft(Integer.parseInt(userid));
		   // int listSize = mailinfo.size(); 可统计收件箱有多少数据
		    session.setAttribute("draft", mailinfo);
			mv.setViewName("redirect:/draft.jsp");
			return mv;
	    }
	//草稿箱发送 更新表状态为1
	@RequestMapping("/draftsendEmail")
	public void draftsendEmail(String emailid,String userid,HttpSession session,HttpServletRequest request)  {
		int state=1;
		usersService.updateEmailstate(Integer.parseInt(emailid),state);
		mailrecvinfoService.updateEmailstate(Integer.parseInt(emailid),state);
	    }
	//删除到垃圾箱	
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
	
	//垃圾箱 （发送箱、收件箱）
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
		
		//垃圾箱  恢复（发送箱、收件箱）
		@RequestMapping("/reduction")
		public void reduction(String emailid,String userid,String type,HttpSession session,HttpServletRequest request)  {
			int state=1;
				if(type.equals("outbox")) {
					usersService.updateEmailstate(Integer.parseInt(emailid),state);
				}else if(type.equals("inbox")){
					mailrecvinfoService.updateEmailstate(Integer.parseInt(emailid),state);
				}
		    }
		//回复 部门 领导问文件
		@RequestMapping("/reply")
		public void reply(String emailid,String userid,HttpSession session,HttpServletRequest request)  {
			mailrecvinfoService.updateEmaireadfalg(Integer.parseInt(emailid),Integer.parseInt(userid));
				
		    }
	
	@RequestMapping("/upload")
	public String uploadMultipartFile(MultipartFile file) {
		String filename = file.getOriginalFilename();//原始文件名		
		try {
			File dest = new File("E:/mvc/uploads/");
			 if (!dest.exists()) { 
				 dest.mkdirs(); 
	             }
	//文件上传到路径下
	          FileUtils.copyInputStreamToFile(file.getInputStream(), new File(dest,filename)); 
			//保存成功

			return filename;
		} catch (Exception e) {
			//保存失败
			e.printStackTrace();
		}
		return "error";
	}

	


	/*
	 * ParsePosition pos = new ParsePosition(8); Date currentTime_2 =
	 * formatter.parse(dateString, pos);
	 */
	
}
