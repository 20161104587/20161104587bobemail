package com.imnu.bobEmail.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imnu.bobEmail.mapper.DepartmentMapper;
import com.imnu.bobEmail.mapper.GrouprecvMapper;
import com.imnu.bobEmail.pojo.Department;
import com.imnu.bobEmail.pojo.DepartmentExample;
import com.imnu.bobEmail.pojo.Grouprecv;

@Service
@Transactional
public class DepartmentServiceImp implements DepartmentService {
	@Autowired
	private DepartmentMapper departmentMapper;
	@Autowired
	private GrouprecvMapper grouprecvMapper;

	@Override
	public void insertgrouprecv(Integer mailid, Integer senderid, Integer integer, Date d) {
		// TODO Auto-generated method stub
		Grouprecv grouprecv =new Grouprecv();
		grouprecv.setMailid(mailid);
		grouprecv.setSenderid(senderid);
		grouprecv.setRecvid(integer);
		grouprecv.setSendtime(d);
		grouprecvMapper.insertSelective(grouprecv);
	}

	@Override
	public List<Department> checkdepartment() {
		DepartmentExample example =new DepartmentExample();
		 List<Department> list =departmentMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deletedepartment(String depid) {
		departmentMapper.deleteByPrimaryKey(Integer.parseInt(depid));
		
	}

	@Override
	public Department selectdepartment(int parseInt) {
		// TODO Auto-generated method stub
		Department dep = departmentMapper.selectByPrimaryKey(parseInt);
		return dep;
	}

	@Override
	public void updatedepartment(Department dep) {
		DepartmentExample example =new DepartmentExample();
		example.createCriteria().andDepidEqualTo(dep.getDepid());
		departmentMapper.updateByExampleSelective(dep, example);		 
	}

	@Override
	public void insertdepartment(Department dep) {
		departmentMapper.insertSelective(dep);		
	}
}
