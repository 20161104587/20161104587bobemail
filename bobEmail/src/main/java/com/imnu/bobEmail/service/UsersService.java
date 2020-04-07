package com.imnu.bobEmail.service;



import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imnu.bobEmail.pojo.Department;
import com.imnu.bobEmail.pojo.Mailinfo;
import com.imnu.bobEmail.pojo.Users;
@Service
public interface UsersService {

	void resgiter(Users user);

	Users login(String email, String pwd);

	void updateuserinformation(Users user);

	void sendEmail(Mailinfo mailinfo);

	Users checkUser(String accept);

	Mailinfo checkEmail(String dateString);

	List<Mailinfo> selectoutbox(int senderid);

	void updateEmailstate(int parseInt, int state);

	List<Mailinfo> selectinbox(int parseInt);

	List<Mailinfo> selectdraft(int parseInt);

	List<Mailinfo> selectdustbinOutbox(int parseInt);

	List<Mailinfo> selectdustbinInbox(int parseInt);

	Mailinfo checkemail(int parseInt);
	Mailinfo checkemailgroup(int parseInt, int i);

	void updateEmail(String title, String body, String attname, Integer mailid);


	void insertfriend(Integer id, Integer id2, Date d);

	List<Users> checkfriend(String userid);

	void delete(String userid, String friendsid);

	List<Users> selectalluser();

	List<Department> selectalldepart();

	List<Integer> checkbumenPeople(int parseInt);

	int checkemailimportflag(String emailid);

	String checkdepartname(String userid);

	Mailinfo checkemaildetail(String emailid);

	Department checklimit(String depid);

	List<Mailinfo> groupemail(int parseInt);
	List<Users> checkmailgroupreply(String emailid);

	List<Users> checkpeople();

	void deletepeople(int parseInt);

	Users selectpeople(int parseInt);

	void updatepeople(Users user);

	void insertpeople(Users user);

	int selectcoutread(Integer id);

	int checkresemail(String email);
	
	

}
