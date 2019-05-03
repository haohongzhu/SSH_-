package com.all.interceptor;

import com.customer.models.Customer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.*;

public class CustomerLoginInterceptor extends AbstractInterceptor{
	public String intercept(ActionInvocation ai) throws Exception {
		Map session = ai.getInvocationContext().getSession();
		Customer c = (Customer)session.get("loginUser");
        if(c != null){ 
            return ai.invoke();
        }else{
            return "login";
        }
    }

}
