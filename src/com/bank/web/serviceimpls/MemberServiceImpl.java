package com.bank.web.serviceimpls;

import com.bank.web.daoImpls.MemberDAOImpl;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService{
	MemberDAO dao;
	public MemberServiceImpl() {
		dao = new MemberDAOImpl();
	}
	public void join(CustomerBean param) {
		dao.insertCustomer(param);
	}

	public CustomerBean login(CustomerBean param) {
		CustomerBean customer = new CustomerBean();
		customer = dao.login();
		System.out.println("다오에 넣고 나온 값 : " + customer);
		if(param.getId().equals(customer.getId())) {
				if(param.getPw().equals(customer.getPw())) {
					System.out.println("회원 일치" + param + "," + customer);
					return customer;
				}
		}else {
			System.out.println("회원불일치" + param + "," + customer);
			customer = null;
		}
		
		return customer;
	}
}