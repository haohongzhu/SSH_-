package com.customer.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class CustomerExitAction extends ActionSupport{
	public String execute(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null){
			session.removeAttribute("loginUser");
		}
		if(session.getAttribute("collects")!=null){
			session.removeAttribute("collects");
		}
		if(session.getAttribute("five_collects")!=null){
			session.removeAttribute("five_collects");
		}
		if(session.getAttribute("collects2")!=null){
			session.removeAttribute("collects2");
		}
		if(session.getAttribute("nowCart")!=null){
			session.removeAttribute("nowCart");
		}
		if(session.getAttribute("nowCartInf")!=null){
			session.removeAttribute("nowCartInf");
		}
		if(session.getAttribute("nowConsignee")!=null){
			session.removeAttribute("nowConsignee");
		}
		if(session.getAttribute("nowOrderStatus")!=null){
			session.removeAttribute("nowOrderStatus");
		}
		if(session.getAttribute("nowStatus")!=null){
			session.removeAttribute("nowStatus");
		}
		if(session.getAttribute("productCollect")!=null){
			session.removeAttribute("productCollect");
		}
		if(session.getAttribute("pes_session")!=null){
			session.removeAttribute("pes_session");
		}
		if(session.getAttribute("now_P")!=null){
			session.removeAttribute("now_P");
		}
		if(session.getAttribute("startTime")!=null){
			session.removeAttribute("startTime");
		}
		if(session.getAttribute("endTime")!=null){
			session.removeAttribute("endTime");
		}
		if(session.getAttribute("allPay")!=null){
			session.removeAttribute("allPay");
		}
		return SUCCESS;
	}
}
