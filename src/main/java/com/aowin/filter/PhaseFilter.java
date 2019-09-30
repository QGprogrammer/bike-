package com.aowin.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.model.SyUser;

/**
 * 权限过滤
 */
@WebFilter("/*")
public class PhaseFilter implements Filter {
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		@SuppressWarnings("unchecked")
		List<String> msPhaseList = (ArrayList<String>) req.getSession().getAttribute("msPhaseList");
		@SuppressWarnings("unchecked")
		List<String> allMsPhase = (ArrayList<String>) req.getSession().getAttribute("allMsPhase");
		SyUser syUser = (SyUser) req.getSession().getAttribute("syUser");
		String uri = req.getRequestURI();
		boolean flag = isFilter(uri,allMsPhase);
		if (flag) {
			if (syUser == null) {
				resp.getWriter().print("noSyUser");
			}else {
				boolean flag2 = isFilter(uri,msPhaseList);
				if(flag2) {
					chain.doFilter(request, response);
				}else {
					resp.getWriter().print("noPhase");
				}
			}
		}else {
			chain.doFilter(request, response);

		}
	}
	/**
	 * 判断是否要过滤该url
	 */
	private boolean isFilter(String uri,List<String> list) {
		if (list != null) {
			for (String str : list) {
				if (uri.contains(str)) {
					return true;
				}
			}
		}
		return false;
	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	/**
	 * Default constructor.
	 */
	public PhaseFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
