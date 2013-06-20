package cn.test.service;

import org.springframework.stereotype.Service;


@Service
public class EmpServiceImpl implements EmpService{

	public void add() throws Exception {
		System.out
				.println("信息输出：这条信息的输出代表正在测试freemarkder和aop的整合，用于在更改主页内容的时候，拦截生成新的主页模板");
	}

	
}
