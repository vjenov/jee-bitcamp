package com.bank.web.domains;

import lombok.Data;

@Data
public class CustomerBean extends MemberBean{
	
	private static final long serialVersionUID = 1L;
	private String credit;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "," + credit + "신용도";
	}
}
