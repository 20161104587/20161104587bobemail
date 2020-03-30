package com.imnu.bobEmail.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.imnu.bobEmail.pojo.Department;

@Service
public interface DepartmentService {

	void insertgrouprecv(Integer mailid, Integer senderid, Integer integer, Date d);

	List<Department> checkdepartment();

	void deletedepartment(String depid);

	Department selectdepartment(int parseInt);

	void updatedepartment(Department dep);

	void insertdepartment(Department dep);

	

}
