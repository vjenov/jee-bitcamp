package com.bank.web.daoImpls;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import com.bank.web.command.LoginCommand;
import com.bank.web.daos.MemberDAO;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.EmployeeBean;
import com.bank.web.pool.Constants;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

import sun.print.resources.serviceui;

public class MemberDAOImpl implements MemberDAO{
	File file = new File(Constants.FILE_PATH+"customer0905.txt");
	@Override
	public void insertCustomer(CustomerBean param) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(String.format("%s, %s, %s, %s, %s", param.getId(), param.getPw(), param.getName(), param.getSsn(), param.getCredit()));
			writer.newLine();
			writer.flush();
			writer.close();
			System.out.println("저장할 내용 : " + String.format("%s, %s, %s, %s, %s", param.getId(), param.getPw(), param.getName(), param.getSsn(), param.getCredit()));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void insertEmployee(EmployeeBean param) {
		try {
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public CustomerBean login() {
		CustomerBean customer = new CustomerBean();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String user = reader.readLine();
			reader.close();
			String[] val = user.split(",");
			customer.setId(val[0]);
			customer.setPw(val[1]);
			customer.setName(val[2]);
			customer.setSsn(val[3]);
			customer.setCredit(val[4]);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
	}

}
