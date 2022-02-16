package com.spring.account;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED) //@Transactional을 이용해 AccountService 클래스의 모든 메서드에 트랜잭션을 적용
public class AccountService {
	private AccountDAO accDAO;
	
	public void setAccDAO(AccountDAO accDAO) {
		this.accDAO = accDAO;
	}
	
	public void sendMoney() throws Exception{
		accDAO.updateBalance1();
		accDAO.updateBalance2();
	}
}
