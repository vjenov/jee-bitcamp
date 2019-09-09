package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;

import com.bank.web.domains.CustomerBean;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class LoginCommand extends MoveCommand{
	public LoginCommand(HttpServletRequest request)throws Exception {
		// TODO Auto-generated constructor stub
		super(request);
	}
@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.execute();
		CustomerBean param= new CustomerBean();
		param.setId(request.getParameter("id"));
		param.setPw(request.getParameter("pw"));
		MemberService service = new MemberServiceImpl();
		CustomerBean customer = service.login(param); 
		System.out.println("로그인 할 회원 정보 : " + customer);
		String page = "";
		if(customer == null) {
			page = "login";
		}else {
			page = "mypage";
		}
		request.setAttribute("customer", customer);
		Receiver.cmd.setPage(page);
		System.out.println("로그인 후 갈 페이지 : " + Receiver.cmd.getView());
	}
}
