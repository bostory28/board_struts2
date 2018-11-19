package board.common;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class InterceptorLogin extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		Map<String, Object> session = context.getSession();
		String id = (String)session.get("id");
		if(id == null) {
			System.out.println("sdf");
			return "login";
		}
		return invocation.invoke();
	}

}
