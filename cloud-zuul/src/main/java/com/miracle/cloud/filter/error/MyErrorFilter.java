package com.miracle.cloud.filter.error;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.ERROR_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_ERROR_FILTER_ORDER;

/**
 * 来自于官方文档的说明，仅仅当RequestContext.getThrowable()不为null的时候，该Filter才会启动工作，
 * 然后它将会在请求中设置特定的javax.servlet.error.* attributes 并将请求转发到错误页面
 * If an exception is thrown during any portion of the Zuul filter lifecycle,
 * the error filters are executed. The SendErrorFilter is only run if RequestContext.getThrowable() is not null.
 * It then sets specific javax.servlet.error.* attributes in the request and forwards the request to the Spring Boot error page.
 */
public class MyErrorFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return ERROR_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_ERROR_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        if(RequestContext.getCurrentContext().getThrowable() != null){
            return true;
        }
        return false;
    }

    @Override
    public Object run() {
        // do something and send the request to the spring boot error page
        return null;
    }
}
