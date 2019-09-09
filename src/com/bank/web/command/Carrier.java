package com.bank.web.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {
	public static void forward(HttpServletRequest request, HttpServletResponse response){
		System.out.println(Receiver.cmd.getView());
		try {
			request.getRequestDispatcher(Receiver.cmd.getView()).forward(request, response);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
