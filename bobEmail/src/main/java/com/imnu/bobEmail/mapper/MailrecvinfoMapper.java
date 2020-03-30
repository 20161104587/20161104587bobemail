package com.imnu.bobEmail.mapper;

import com.imnu.bobEmail.pojo.Mailrecvinfo;
import com.imnu.bobEmail.pojo.MailrecvinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MailrecvinfoMapper {
    long countByExample(MailrecvinfoExample example);

    int deleteByExample(MailrecvinfoExample example);

    int deleteByPrimaryKey(Integer recvid);

    int insert(Mailrecvinfo record);

    int insertSelective(Mailrecvinfo record);

    List<Mailrecvinfo> selectByExample(MailrecvinfoExample example);

    Mailrecvinfo selectByPrimaryKey(Integer recvid);

    int updateByExampleSelective(@Param("record") Mailrecvinfo record, @Param("example") MailrecvinfoExample example);

    int updateByExample(@Param("record") Mailrecvinfo record, @Param("example") MailrecvinfoExample example);

    int updateByPrimaryKeySelective(Mailrecvinfo record);

    int updateByPrimaryKey(Mailrecvinfo record);

	void updateRevEmailid(Integer mailid, Integer id);

	void updateEmaireadfalg(int parseInt, int parseInt2);


}