package com.imnu.bobEmail.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.bobEmail.mapper.DepartmentMapper;
import com.imnu.bobEmail.mapper.FriendsMapper;
import com.imnu.bobEmail.mapper.MailinfoMapper;
import com.imnu.bobEmail.mapper.UsersMapper;
import com.imnu.bobEmail.pojo.Department;
import com.imnu.bobEmail.pojo.DepartmentExample;
import com.imnu.bobEmail.pojo.Friends;
import com.imnu.bobEmail.pojo.Mailinfo;
import com.imnu.bobEmail.pojo.MailinfoExample;
import com.imnu.bobEmail.pojo.Users;
import com.imnu.bobEmail.pojo.UsersExample;



@Service
@Transactional
public class UserServiceImp implements UsersService {
	@Autowired
	private UsersMapper usermapper;
	@Autowired
	private MailinfoMapper mailinfoMapper;
	@Autowired
	private FriendsMapper friendsMapper;
	@Autowired
	private DepartmentMapper departmentMapper;
	
	
	public void resgiter(Users user) {
		usermapper.insertSelective(user);
	}


	public Users login(String email, String pwd) {
		// TODO Auto-generated method stub
		UsersExample userExample = new UsersExample();
		userExample.createCriteria().andEmailEqualTo(email).andPwdEqualTo(pwd);
		List<Users> user=usermapper.selectByExample(userExample);
		return user==null?null :user.get(0);
		
	}


	@Override
	public void updateuserinformation(Users user) {
		UsersExample usersExample =new UsersExample();
		usersExample.createCriteria().andIdEqualTo(user.getId());
		usermapper.updateByExampleSelective(user, usersExample);	
	}


	@Override
	public void sendEmail(Mailinfo mailinfo) {
		mailinfoMapper.insertSelective(mailinfo);
	}


	@Override
	public Users checkUser(String accept) {
		// TODO Auto-generated method stub
		UsersExample usersExample =new UsersExample();
		usersExample.createCriteria().andEmailEqualTo(accept);
		List<Users> user =usermapper.selectByExample(usersExample);
		return user==null?null :user.get(0);
	}




	@Override
	public Mailinfo checkEmail(String dateString) {
		// TODO Auto-generated method stub
		Mailinfo mail =mailinfoMapper.selectBydateString(dateString);
		return mail;
	}


	@Override
	public List<Mailinfo> selectoutbox(int senderid) {
		// TODO Auto-generated method stub
		List<Mailinfo> list = mailinfoMapper.selectoutbox(senderid);
		return list;
	}

	@Override
	public List<Mailinfo> selectinbox(int parseInt) {
		// TODO Auto-generated method stub
		List<Mailinfo> list = mailinfoMapper.selectinbox(parseInt);
		return list;
	}


	@Override
	public List<Mailinfo> selectdraft(int parseInt) {
		// TODO Auto-generated method stub
		List<Mailinfo> list = mailinfoMapper.selectdraft(parseInt);
		return list;
	}


	@Override
	public void updateEmailstate(int parseInt, int state) {
		// TODO Auto-generated method stub
		MailinfoExample mailinfoExample = new MailinfoExample();
		mailinfoExample.createCriteria().andMailidEqualTo(parseInt);
		Mailinfo mail =new Mailinfo();
		mail.setState(state);
		mailinfoMapper.updateByExampleSelective(mail, mailinfoExample);
	}


	@Override
	public List<Mailinfo> selectdustbinOutbox(int parseInt) {
		// TODO Auto-generated method stub
		List<Mailinfo> list = mailinfoMapper.selectdustbinOutbox(parseInt);
		return list;
	}


	@Override
	public List<Mailinfo> selectdustbinInbox(int parseInt) {
		// TODO Auto-generated method stub
		List<Mailinfo> list = mailinfoMapper.selectdustbinInbox(parseInt);
		return list;
	}


	@Override
	public Mailinfo checkemail(int parseInt) {
		Mailinfo list =mailinfoMapper.checkemail(parseInt);
		return list;
	}


	@Override
	public void updateEmail(String title, String body, String attname, Integer mailid) {
		MailinfoExample mailinfoExample = new MailinfoExample();
		mailinfoExample.createCriteria().andMailidEqualTo(mailid);
		Mailinfo mail =new Mailinfo();
	    mail.setAttname(attname);
	    mail.setTitle(title);
	    mail.setBody(body);
		mailinfoMapper.updateByExampleSelective(mail, mailinfoExample);
		
	}



	@Override
	public void insertfriend(Integer id, Integer id2, Date d) {
		// TODO Auto-generated method stub
		Friends friends =new Friends();
		friends.setUserid(id2);
		friends.setFriendid(id);
		friends.setAddtime(d);
		friendsMapper.insertSelective(friends);
	}


	@Override
	public List<Users> checkfriend(String userid) {
		// TODO Auto-generated method stub
		List<Users> friends = friendsMapper.checkfriend(Integer.parseInt(userid));
		return friends;
	}


	@Override
	public void delete(String userid, String friendsid) {
		
		friendsMapper.deletefriend(Integer.parseInt(userid),Integer.parseInt(friendsid));
	}


	@Override
	public List<Users> selectalluser() {
		// TODO Auto-generated method stub
		UsersExample usersExample =new UsersExample();
		List<Users> user =usermapper.selectByExample(usersExample);
		return user;
	}


	@Override
	public List<Department> selectalldepart() {
		// TODO Auto-generated method stub
		DepartmentExample departmentExample = new DepartmentExample();
		List<Department> depart=departmentMapper.selectByExample(departmentExample);
		return depart;
		
		
	}


	@Override
	public List<Integer> checkbumenPeople(int parseInt) {
		// TODO Auto-generated method stub
		List<Integer> list = usermapper.selectbumenpeople(parseInt);
		return list;
	}


	@Override
	public int checkemailimportflag(String emailid) {
		// TODO Auto-generated method stub
		int s=mailinfoMapper.selectimportflag(Integer.parseInt(emailid));
		return s;
	}


	@Override
	public Mailinfo checkemailgroup(int parseInt, int i) {
		// TODO Auto-generated method stub
		Mailinfo list =mailinfoMapper.checkemailgroup(parseInt,i);
		return list;
	}


	@Override
	public String checkdepartname(String userid) {
		// TODO Auto-generated method stub
		String depname = departmentMapper.checkdepname(Integer.parseInt(userid));
		return depname;
	}


	@Override
	public Mailinfo checkemaildetail(String emailid) {
		// TODO Auto-generated method stub
		

		Mailinfo Mail =mailinfoMapper.selectByemailid(Integer.parseInt(emailid));
		return Mail;
	}


	@Override
	public Department checklimit(String depid) {
		// TODO Auto-generated method stub
		
		
		DepartmentExample departmentExample = new DepartmentExample();
		departmentExample.createCriteria().andDepidEqualTo(Integer.parseInt(depid));
		List<Department> depart=departmentMapper.selectByExample(departmentExample);
		return depart==null?null :depart.get(0);
		
		
	}


	@Override
	public List<Mailinfo> groupemail(int parseInt) {
		// TODO Auto-generated method stub
		
		List<Mailinfo> list = mailinfoMapper.selectgroupemail(parseInt);
		return list;
	}


	@Override
	public List<Users> checkmailgroupreply(String emailid) {
		// TODO Auto-generated method stub
		List<Users>  user =usermapper.checkmailgroupreply(Integer.parseInt(emailid));
		return user;
	}


	@Override
	public List<Users> checkpeople() {
		// TODO Auto-generated method stub
		List<Users> user =usermapper.selectByExample(new UsersExample());
		return user;
	}


	@Override
	public void deletepeople(int parseInt) {
		
		usermapper.deleteByPrimaryKey(parseInt);
	}


	@Override
	public Users selectpeople(int parseInt) {
		// TODO Auto-generated method stub
		Users user =usermapper.selectByPrimaryKey(parseInt);
		return user;
	}


	@Override
	public void updatepeople(Users user) {
		UsersExample usersExample =new UsersExample();
		usersExample.createCriteria().andIdEqualTo(user.getId());
		usermapper.updateByExampleSelective(user, usersExample);
		
	}


	@Override
	public void insertpeople(Users user) {
		usermapper.insertSelective(user);
		
	}


	@Override
	public int selectcoutread(Integer id) {
		// TODO Auto-generated method stub
		usermapper.selectcoutread(id);
		return usermapper.selectcoutread(id);
	}






	
	

}
