package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.tribes.membership.MemberImpl;

import com.bank.web.domains.CustomerBean;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class CreateCommand extends MoveCommand{
	public CreateCommand(HttpServletRequest request) throws Exception{
		// TODO Auto-generated constructor stub
		super(request);
	}
	public void execute() {
		super.execute();
		CustomerBean param = new CustomerBean();
		param.setId(request.getParameter("id"));
		param.setPw(request.getParameter("pw"));
		param.setName(request.getParameter("name"));
		param.setSsn(request.getParameter("ssn"));
		param.setCredit(request.getParameter("credit"));
		System.out.println("회원정보 : " + param.toString());
		MemberService service = new MemberServiceImpl();
		service.join(param);
		Receiver.cmd.setPage("login");
		System.out.println("회원가입 후 갈 페이지 : " + Receiver.cmd.getView());
	}
}
