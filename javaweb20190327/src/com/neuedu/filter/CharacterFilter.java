package com.neuedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*@WebFilter("/*")*/
public class CharacterFilter implements Filter {
    private FilterConfig config;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     this.config=filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * 1:提取字符编码的定义
         */
        ServletContext context=config.getServletContext();
        String charset=context.getInitParameter("charset");

        /**
         * 2：HttpServletRequest HttpServletResponse对象进行编码赋值
         * 2.1:将已知servletRequest对象强转为HttpServletRequest对象
         * 2.2:编码赋值
         * 2.3将已知servletResponse对象强转为HttpServletResponse对象
         * 2.4：编码赋值
         */

        HttpServletRequest request=(HttpServletRequest)servletRequest;
        request.setCharacterEncoding(charset);

        HttpServletResponse response=(HttpServletResponse)servletResponse;
        response.setContentType("text/html;charset="+charset);
        response.setCharacterEncoding(charset);

        System.out.println("charset处理前");

      filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("charset处理后");
    }

    @Override
    public void destroy() {

    }
}
