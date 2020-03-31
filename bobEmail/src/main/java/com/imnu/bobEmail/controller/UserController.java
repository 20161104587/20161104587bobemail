package com.imnu.bobEmail.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.imnu.bobEmail.mapper.DepartmentMapper;
import com.imnu.bobEmail.pojo.Department;
import com.imnu.bobEmail.pojo.Mailinfo;
import com.imnu.bobEmail.pojo.Users;
import com.imnu.bobEmail.service.DepartmentService;
import com.imnu.bobEmail.service.MailrecvinfoService;
import com.imnu.bobEmail.service.UsersService;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Autowired
	private UsersService usersService;
	 @Autowired
	 private MailrecvinfoService mailrecvinfoService;
	 @Autowired
	 private DepartmentService departmentService;
	//登录
	@RequestMapping("/login")
	public ModelAndView login(Users user,HttpSession session)  {

		ModelAndView mv=new ModelAndView();
		Users u=usersService.login(user.getEmail(),user.getPwd());
		int countread = usersService.selectcoutread(u.getId());
		session.setAttribute("countread", countread);
	    session.setAttribute("User", u);
		mv.setViewName("redirect:/index.jsp");
		return mv;
	    }
	//注册
	@RequestMapping("/resgiter")
	public ModelAndView resgiter(Users user) {

		ModelAndView mv=new ModelAndView();
		usersService.resgiter(user);
		mv.setViewName("redirect:/login.jsp");
		return mv;
	    }
	//更新个人信息
	@RequestMapping("/updateuserinformation")
	public ModelAndView updateuserinformation(Users user,HttpSession session) {
		System.out.println("进来了");
		System.out.println(user.getId());
		ModelAndView mv=new ModelAndView();
		usersService.updateuserinformation(user);
		mv.setViewName("redirect:/index.jsp");
		return mv;
	    }
	
	//下载附件
	   @RequestMapping("/download")
	   public void download(HttpServletRequest request,HttpServletResponse response) throws IOException {
		   String filename =request.getParameter("filename");
	       //模拟文件，myfile.txt为需要下载的文件  
		   System.out.println("下载 下载");
		   System.out.println(filename);
	       String path = "E:\\mvc\\uploads"+"\\"+filename;  
	       //获取输入流  
	       InputStream bis = new BufferedInputStream(new FileInputStream(new File(path)));
	       //转码，免得文件名中文乱码  
	       filename = URLEncoder.encode(filename,"UTF-8");  
	       //设置文件下载头  
	       response.addHeader("Content-Disposition", "attachment;filename=" + filename);    
	       //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型    
	       response.setContentType("multipart/form-data");   
	       BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
	       int len = 0;  
	       while((len = bis.read()) != -1){  
	           out.write(len);  
	           out.flush();  
	       }  
	       out.close();  
	   }
	   
		//查看email  收件箱子详细信息
		@RequestMapping("/checkemail")
		public ModelAndView checkemail(String emailid,String userid,String type,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println(type);
			int flag=usersService.checkemailimportflag(emailid);
			System.out.println(flag);
			if(flag==1) {//群发邮件
				if(type.equals("inbox")) {
					Mailinfo email =usersService.checkemailgroup(Integer.parseInt(emailid),Integer.parseInt(userid));
					session.setAttribute("email",email);
					mv.setViewName("redirect:/checkemail.jsp");
				}else if(type.equals("outbox")) {
					String depname=usersService.checkdepartname(userid);
					System.out.println(emailid);
					Mailinfo email =usersService.checkemaildetail(emailid);
					System.out.println(email.getAttname()+email.getBody()+email.getTitle());
					email.setRecvemail(depname);
					session.setAttribute("email",email);
					mv.setViewName("redirect:/checkemail.jsp");
				}
				
			}else {
			Mailinfo email =usersService.checkemail(Integer.parseInt(emailid));
			session.setAttribute("email",email);
			mv.setViewName("redirect:/checkemail.jsp");
		    }
			return mv;
		}

		
		//更新 email信息 跳转页面	
		@RequestMapping("/updateemail")
		public ModelAndView updateemail(String emailid,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			Mailinfo email =usersService.checkemail(Integer.parseInt(emailid));
			session.setAttribute("updateemail",email);
			mv.setViewName("redirect:/updateemail.jsp");
			return mv;
		    }
	//更新email信息  更新email
		
		
		@RequestMapping("/updateemmail1")
		public ModelAndView updateemmail1(Mailinfo mailinfo,MultipartFile file,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			Users acceptinformation =usersService.checkUser(mailinfo.getRecvemail());
			usersService.updateEmail(mailinfo.getTitle(),mailinfo.getBody(),mailinfo.getAttname(),mailinfo.getMailid());
			//由于主键文题 修改recv中的 表错误 所以 该功能在修改草稿是后 不能修改收件人的email
			mailrecvinfoService.updateEmailinformation(mailinfo.getMailid(),acceptinformation.getId());
			mv.setViewName("redirect:/draft.jsp");
			return mv;
		    }
		
		
		@RequestMapping("/addressbook")
		public ModelAndView addressbook(String userid,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			List<Users> friend=usersService.checkfriend(userid);
			System.out.println(friend);
			session.setAttribute("friends", friend);
			mv.setViewName("redirect:/addressbook.jsp");
			return mv;
		    }
		@RequestMapping("/insertaddressbook")
		public ModelAndView insertaddressbook(Users user,HttpSession session) {
			System.out.println("添加购物车");
			System.out.println(user.getEmail());
			System.out.println(user.getId());
			ModelAndView mv=new ModelAndView();
			Users friendinformation =usersService.checkUser(user.getEmail());
			if(friendinformation==null) {
				mv.setViewName("redirect:/404.jsp");
			}else {
			Date d =new Date();
			usersService.insertfriend(friendinformation.getId(),user.getId(),d);
			mv.setViewName("redirect:/addressbook.jsp");
		}
			return mv;
		    }
		@RequestMapping("/deletefirends")
		public ModelAndView deletefirends(String userid,String friendsid,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println(userid);
			usersService.delete(userid,friendsid);
			mv.setViewName("redirect:/addressbook.jsp");
			return mv;
		    }
		
		@RequestMapping("/tiaozhuan")
		public ModelAndView tiaozhuan(String email,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			session.setAttribute("email", email);
			mv.setViewName("redirect:/sendEmail.jsp");
			return mv;
		    }
		
		@RequestMapping("/alluser")
		public ModelAndView  alluser(String userid,String depid,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println(depid);
			System.out.println("alluser进来了");
			System.out.println(userid);
			Department deprole=usersService.checklimit(depid);
			String str =deprole.getDeprole();
			System.out.println(str);
			if(str.contains("部门")) {
				List<Department> depart =usersService.selectalldepart();
				session.setAttribute("depart", depart);
			}else if(str.contains("公司")){
				List<Users> list =usersService.selectalluser();
				session.setAttribute("yuangong", list);
			}
			mv.setViewName("redirect:/sendEmailGroup.jsp");
			return mv;
		    }
		
		//
		
		@RequestMapping("/checkmailgroupreply")
		public ModelAndView  checkmailgroupreply(String userid,String emailid,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("查看回复状态进来了");
			System.out.println(userid);
			List<Users> user=usersService.checkmailgroupreply(emailid);

			session.setAttribute("checkmailgroupreply", user);
			mv.setViewName("redirect:/mailgroupreply.jsp");
			return mv;
		    }
		
		
		@RequestMapping("/checkdepartment")
		public ModelAndView  checkdepartment(String userrole,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("查看编辑部门进来了");
			System.out.println(userrole);
			if(Boolean.parseBoolean(userrole)) {
				List<Department> dep=departmentService.checkdepartment();
				session.setAttribute("checkdepartment", dep);
				mv.setViewName("redirect:/department.jsp");
			}else {
				mv.setViewName("redirect:/404.jsp");
			}
			return mv;
		    }
		@RequestMapping("/deletedepartment")
		public void  deletedepartment(String depid,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("删除部门进来了");
			System.out.println(depid);
			departmentService.deletedepartment(depid);
		    }
		
		
		@RequestMapping("/updatdepartment")
		public ModelAndView  updatdepartment(String depid,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("更新部门进来了");
			System.out.println(depid);
			Department dep=departmentService.selectdepartment(Integer.parseInt(depid));
			session.setAttribute("dep", dep);
			mv.setViewName("redirect:/updatedepartment.jsp");
			return mv;
		    }
		@RequestMapping("/updatedepartmentinformation")
		public ModelAndView  updatedepartmentinformation(Department dep,String deppid,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("更新部门信息进来了");
			System.out.println(deppid);
			dep.setDepid(Integer.parseInt(deppid));
		    departmentService.updatedepartment(dep);
			mv.setViewName("redirect:/index.jsp");
			return mv;
		    }
		
		@RequestMapping("/insertdepartment")
		public ModelAndView  insertdepartment(Department dep,String userrole,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("更新部门信息进来了");
			if(Boolean.parseBoolean(userrole)) {
		    departmentService.insertdepartment(dep);
			mv.setViewName("redirect:/index.jsp");
			
		    }else {
				mv.setViewName("redirect:/404.jsp");
			}
			return mv;
		}
		
		
		
		@RequestMapping("/checkuser")
		public ModelAndView  checkuser(String userrole,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("查看员工进来了");
			System.out.println(userrole);
			if(Boolean.parseBoolean(userrole)) {
				List<Users> user=usersService.checkpeople();
				session.setAttribute("user", user);
				mv.setViewName("redirect:/people.jsp");
			}else {
				mv.setViewName("redirect:/404.jsp");
			}
			return mv;
		    }
		
		
	
		@RequestMapping("/deletepeople")
		public void  deletepeople(String id,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("删除员工进来了");
			System.out.println(id);
			usersService.deletepeople(Integer.parseInt(id));
		    }
		
		@RequestMapping("/updatepeople")
		public ModelAndView  updatepeople(String id,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("更新员工进来了");
			System.out.println(id);
			Users user=usersService.selectpeople(Integer.parseInt(id));
			session.setAttribute("updateuser", user);
			mv.setViewName("redirect:/updatepeople.jsp");
			return mv;
		    }
		
		@RequestMapping("/updatepeopleinformation")
		public ModelAndView  updatepeopleinformation(Users user,String userid,String isadmins,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("更新员工信息进来了");
			System.out.println(isadmins);
			System.out.println(userid);
			user.setId(Integer.parseInt(userid));
			if(isadmins.equals("是")) {
				user.setIsadmin(true);
			}else {
				user.setIsadmin(false);
			}
			usersService.updatepeople(user);
			mv.setViewName("redirect:/index.jsp");
			return mv;
		    }
		
		@RequestMapping("/insertpeople")
		public ModelAndView  insertpeople(Users user,String userrole,HttpSession session) {
			ModelAndView mv=new ModelAndView();
			System.out.println("插入人员信息进来了");
			if(Boolean.parseBoolean(userrole)) {
		    usersService.insertpeople(user);
			mv.setViewName("redirect:/index.jsp");
		    }else {
				mv.setViewName("redirect:/404.jsp");
			}
			return mv;
		}
		
		
}
