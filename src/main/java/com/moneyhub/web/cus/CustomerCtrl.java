package com.moneyhub.web.cus;

import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.moneyhub.web.pxy.Box;
import com.moneyhub.web.pxy.Proxy;

@RestController
@RequestMapping("/customers")
public class CustomerCtrl extends Proxy{
	
	@Autowired Customer cus;
	@Autowired CustomerMapper customerMapper;
	@Autowired Box<Object> box;
	@Autowired SqlSession sqlsession;
	//@Autowired CustMailSender mailSender;
	//private HttpServletRequest  request;

	@PostMapping("/login")
	public Map<?, ?> login(@RequestBody Customer param){
		System.out.println(param.toString());
		Function<Customer, Customer> f = t -> customerMapper.login(t);
		cus = f.apply(param);
	//	System.out.println(cus.getCemail());
		String result = ( cus != null ) ? "SUCCESS" : "FAIL";
		box.clear();
		box.put("msg", result);
		box.put("cus", cus);
		System.out.println(box.get()); 
		
		return box.get();
	}
	
	@PostMapping("/")
	public Map<?, ?> join(@RequestBody Customer param) {
		System.out.println("join 들어옴");
		System.out.println(param.toString());
		Consumer<Customer> c = o -> customerMapper.join(o);
		c.accept(param);
		System.out.println("첫번째 비번: "+param.getCpwd());
		String encrypwd = CustomerSha256.encrypt(param.getCpwd());
		param.setCpwd(encrypwd);
		System.out.println("두번째 비번: "+param.getCpwd());
		customerMapper.join(param);
		//mailSender.mailSendWithUserKey(param.getCemail(), request);
		box.clear();
		box.put("msg", "SUCCESS");
		return box.get();
	}
	
	@GetMapping("/existid/{cemail}")
	public Map<?, ?> existId(@PathVariable String cemail){
		System.out.println("existid 들어옴");
		Function<String, Integer> f = o -> customerMapper.existId(o);
		box.clear();
		box.put("msg", ( f.apply(cemail) != 0 ) ? "Y" : "N");
		System.out.println(box.get());
		return box.get();
	}
	
//	@PostMapping("/pwdCheck")
//	public Map<?, ?> pwdCheck(@RequestBody Customer param) {
		//Function<Customer, Customer> f = t -> cusMapper.login(t);
		//cus = f.apply(param);
//		int result = cusMapper.pwdCheck(param);
//		String result2 = Integer.toString(result);
//		System.out.println("비밀번호 체크1 : "+result);
//		System.out.println("비밀번호 체크2 : "+result2);
//		box.clear();
//		box.put("msg", result2);
//		return box.get();
//	}
	
	@DeleteMapping("/withdrawal")
	public Map<?, ?> withdrawal(@RequestBody Customer param){
		System.out.println("자바 withdrawal 들어옴");
		//Customer cust = (Customer)session.getAttribute("cust");
		//System.out.println("cust는? "+ cust);
		
		String cpwd = cus.getCpwd();
		String cpwd2 = param.getCpwd();
		System.out.println("cpwd는? " + cpwd + " / cpwd2는? " + cpwd2);
		System.out.println("cus.getCpwd()는? " + cus.getCpwd() + " / param.getCpwd()는? " + param.getCpwd());
		box.clear();
		box.put("msg", (cpwd.equals(cpwd2)) ? "true" : "false"); 
		if((cpwd.equals(cpwd2))) {
			Consumer<Customer> c = o -> customerMapper.withdrawal(o);
			c.accept(param);
			box.put("msg", "true");
		}else {
			box.put("msg", "false");
		}

		System.out.println("박스에 담긴 메시지"+box.get("msg"));
		return box.get();
	}
	
}
