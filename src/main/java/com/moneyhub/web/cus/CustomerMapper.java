package com.moneyhub.web.cus;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerMapper {
	
	public void join(Customer param);
	public Customer login(Customer param);
	public int existId(String id);
	public void pwdSha(Customer param);
//	public int pwdCheck(Customer param);
	public void withdrawal(Customer param);
}
