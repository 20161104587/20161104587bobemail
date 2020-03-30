package com.imnu.bobEmail.mapper;

import com.imnu.bobEmail.pojo.Grouprecv;
import com.imnu.bobEmail.pojo.GrouprecvExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface GrouprecvMapper {
    long countByExample(GrouprecvExample example);

    int deleteByExample(GrouprecvExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Grouprecv record);

    int insertSelective(Grouprecv record);

    List<Grouprecv> selectByExample(GrouprecvExample example);

    Grouprecv selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Grouprecv record, @Param("example") GrouprecvExample example);

    int updateByExample(@Param("record") Grouprecv record, @Param("example") GrouprecvExample example);

    int updateByPrimaryKeySelective(Grouprecv record);

    int updateByPrimaryKey(Grouprecv record);
}