package com.imnu.bobEmail.mapper;

import com.imnu.bobEmail.pojo.Mailinfo;
import com.imnu.bobEmail.pojo.MailinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;
@Repository
public interface MailinfoMapper {
    long countByExample(MailinfoExample example);

    int deleteByExample(MailinfoExample example);

    int deleteByPrimaryKey(Integer mailid);

    int insert(Mailinfo record);

    int insertSelective(Mailinfo record);

    List<Mailinfo> selectByExampleWithBLOBs(MailinfoExample example);

    List<Mailinfo> selectByExample(MailinfoExample example);

    Mailinfo selectByPrimaryKey(Integer mailid);

    int updateByExampleSelective(@Param("record") Mailinfo record, @Param("example") MailinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") Mailinfo record, @Param("example") MailinfoExample example);

    int updateByExample(@Param("record") Mailinfo record, @Param("example") MailinfoExample example);

    int updateByPrimaryKeySelective(Mailinfo record);

    int updateByPrimaryKeyWithBLOBs(Mailinfo record);

    int updateByPrimaryKey(Mailinfo record);

	Mailinfo selectBydateString(String dateString);

	List<Mailinfo> selectoutbox(int senderid);

	List<Mailinfo> selectinbox(int parseInt);

	List<Mailinfo> selectdraft(int parseInt);

	List<Mailinfo> selectdustbinOutbox(int parseInt);
	
	List<Mailinfo> selectdustbinInbox(int parseInt);

	Mailinfo checkemailgroup(int parseInt,int i);
	Mailinfo checkemail(int parseInt);

	int selectimportflag(int parseInt);


	Mailinfo selectByemailid(int parseInt);

	List<Mailinfo> selectgroupemail(int parseInt);

	
}