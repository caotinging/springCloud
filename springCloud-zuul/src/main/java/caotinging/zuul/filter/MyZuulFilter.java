package caotinging.zuul.filter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author caoting
 * @date 2018年4月28日
 */
public class MyZuulFilter extends ZuulFilter {

	/**
	 * 过滤的具体逻辑
	 */
	@Override
	public Object run() {
		//获取token参数判断是否存在
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		String token = request.getParameter("token");
		
		if(token == null) {
			//验证失败
			HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=utf-8"); //设置相应格式
			response.setStatus(401);
			try {
				response.getWriter().print("验证失败");
			} catch (IOException e) {
				e.printStackTrace();
			}
			//验证不通过不进行路由
			RequestContext.getCurrentContext().setSendZuulResponse(false);
			return null;
		}
		System.out.println("success");
		return null;
	}

	/**
	 * 判断是否进入这个拦截器
	 */
	@Override
	public boolean shouldFilter() {
		//可写复杂的判断逻辑
		return true;
	}

	/**
	 * 拦截顺序
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 过滤器类型：
	 * PRE：请求被路由之前被调用，身份验证 
	 * ROUTING：将请求路由到微服务。 
	 * POST：路由到微服务之后执行
	 * ERROR：在其他阶段发生错误时执行。
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
