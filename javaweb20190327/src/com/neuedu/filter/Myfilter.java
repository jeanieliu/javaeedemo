package com.neuedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 1：@WebFilter("/*")所有文件都进行处理
 * 2：@WebFilter("*.html")只处理HTML文件
 */
@WebFilter("*.html")
public class Myfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("创建并初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("处理前");
        /**
         * 1：如果只要一个过滤器：允许通过--放行
         * 2：但是有多个过滤器：调用下一个过滤器，最有一个调用完成，则允许通过
         */
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("处理后");
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
